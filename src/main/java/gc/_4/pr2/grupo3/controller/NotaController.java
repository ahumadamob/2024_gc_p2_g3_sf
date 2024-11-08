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
import gc._4.pr2.grupo3.entity.Nota;
import gc._4.pr2.grupo3.service.INotaService;

@RestController

public class NotaController {
	
	private INotaService service;
	
	
	@GetMapping("/Nota")
	public RespuestaDto<List<Nota>> buscarTodos(){
		List<Nota> listaNOTA;
		listaNOTA = new ArrayList();
		listaNOTA = service.mostrarTodo();
		
		RespuestaDto<List<Nota>> dto;
		dto = new RespuestaDto<List<Nota>>();		
		
		if(listaNOTA.isEmpty()) {
			dto.setEstado(false);
			List<String> mensajes = new ArrayList();
			mensajes.add("No se encontraron Notas");
			dto.setMensaje(mensajes);
			dto.setData(null);
		}else {
			List<String> mensajes = new ArrayList();
			mensajes.add("Se encontraron los siguientes Notas");
			mensajes.add("Todo salio bien");
			dto.setEstado(true);
			dto.setMensaje(mensajes);
			dto.setData(listaNOTA);
		}		
		return dto;
		
	}

	@GetMapping("/Nota/{id}")
	public RespuestaDto<Nota> buscarPorId(@PathVariable("id") Long id){
		if(service.existe(id)) {
			Nota nota = new Nota();
			nota = service.mostrarPorId(id);
			RespuestaDto<Nota> dto;
			dto = new RespuestaDto<Nota>(true, "OK", nota);
			return dto;
		}else {			
			return new RespuestaDto<Nota>(false, "No existen notas con el id ", null);
		}
		
		
	}

	@PostMapping("/api/nota")
    public RespuestaDto<Nota> crearNuevoNota(@RequestBody Nota nota) {
        if (service.existe(nota.getId())) {
            return new RespuestaDto<>(false, "Error: El ID ya existe", null);
        }
        Nota notaGuardado = service.guardar(nota); 
        return new RespuestaDto<>(true, "Nota creada exitosamente", notaGuardado);
    }

	@PutMapping("/Nota")
	public RespuestaDto<Nota> actualizar(@RequestBody Nota notaDesdeElPostman){
		if(service.existe(notaDesdeElPostman.getId())) {
			return new RespuestaDto<Nota>(true, "Nota actualizada con exito", service.guardar(notaDesdeElPostman));
		}else {
			return new RespuestaDto<Nota>(false, "No se encontró el ID" + notaDesdeElPostman.getId().toString(), null);
		}		
	}

	@DeleteMapping("/Nota/{ideliminar}")
	public RespuestaDto<?> eliminar(@PathVariable("ideliminar") Long id){
		if(service.existe(id)) {
			service.eliminarPorId(id);
			return new RespuestaDto<>(true, "Elemento eliminado el ID: " + id.toString(), null);
		}else {
			return new RespuestaDto<>(false, "No se encontró el ID" + id.toString(), null);
		}
		
	}

}
