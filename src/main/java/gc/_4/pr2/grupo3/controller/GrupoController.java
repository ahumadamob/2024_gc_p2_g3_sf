package gc._4.pr2.grupo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo3.dto.RespuestaDto;
import gc._4.pr2.grupo3.entity.Grupo;
import gc._4.pr2.grupo3.service.IGrupoService;

@RestController

public class GrupoController {

	@Autowired
	private IGrupoService service;
	
	@GetMapping("/grupo")
	public RespuestaDto<List<Grupo>> buscarTodos(){
		List<Grupo> listaGrupo;
		listaGrupo = new ArrayList();
		listaGrupo = service.mostrarTodo();

		RespuestaDto<List<Grupo>> dto;
		dto = new RespuestaDto<List<Grupo>>();		

		if(listaGrupo.isEmpty()) {
			dto.setEstado(false);
			List<String> mensajes = new ArrayList();
			mensajes.add("No se encontraron Grupos");
			dto.setMensaje(mensajes);
			dto.setData(null);
		}else {
			List<String> mensajes = new ArrayList();
			mensajes.add("Se encontraron los siguientes Grupos");
			dto.setEstado(true);
			dto.setMensaje(mensajes);
			dto.setData(listaGrupo);
		}		
		return dto;
	}
	
	@GetMapping("/grupo/{id}")
	public RespuestaDto<Grupo> buscarPorId(@PathVariable("id") Long id){
		if(service.existe(id)) {
			Grupo grupo = new Grupo();
			grupo = service.mostrarPorId(id);
			RespuestaDto<Grupo> dto;
			dto = new RespuestaDto<Grupo>(true, "El grupo con el id ingresado es:", grupo);
			return dto;
		}else {			
			return new RespuestaDto<Grupo>(false, "No existen grupos con el id ", null);
		}
	}

	@PostMapping("/api/grupo")
    public RespuestaDto<Grupo> crearNuevoNota(@RequestBody Grupo grupo) {
        if (service.existe(grupo.getId())) {
            return new RespuestaDto<>(false, "Error: El ID ya existe", null);
        }
        Grupo grupoGuardado = service.guardar(grupo); 
        return new RespuestaDto<>(true, "Grupo creado exitosamente", grupoGuardado);
    }
	
	@PutMapping("/grupo")
	public RespuestaDto<Grupo> actualizar(@RequestBody Grupo grupo){
		if(service.existe(grupo.getId())) {
			return new RespuestaDto<Grupo>(true, "Grupo actualizada con exito", service.guardar(grupo));
		}else {
			return new RespuestaDto<Grupo>(false, "No se encontró el ID" + grupo.getId().toString(), null);
		}		
	}
	
	@DeleteMapping("/grupo/{ideliminar}")
	public RespuestaDto<?> eliminar(@PathVariable("ideliminar") Long id){
		if(service.existe(id)) {
			service.eliminarPorId(id);
			return new RespuestaDto<>(true, "Elemento eliminado el ID: " + id.toString(), null);
		}else {
			return new RespuestaDto<>(false, "No se encontró el ID" + id.toString(), null);
		}
	}
}
