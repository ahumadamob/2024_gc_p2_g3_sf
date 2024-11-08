package gc._4.pr2.grupo3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo3.dto.RespuestaDto;
import gc._4.pr2.grupo3.entity.Contacto;
import gc._4.pr2.grupo3.service.IContactoService;

@RestController

public class ContactoController {

	@Autowired
	private IContactoService service;
	
	
	@GetMapping("/Contacto")
	public RespuestaDto<List<Contacto>> buscarTodos(){
		List<Contacto> listaContacto;
		listaContacto = new ArrayList();
		listaContacto = service.mostrarTodo();

		RespuestaDto<List<Contacto>> dto;
		dto = new RespuestaDto<List<Contacto>>();		

		if(listaContacto.isEmpty()) {
			dto.setEstado(false);
			List<String> mensajes = new ArrayList();
			mensajes.add("No se encontraron Contactos");
			dto.setMensaje(mensajes);
			dto.setData(null);
		}else {
			List<String> mensajes = new ArrayList();
			mensajes.add("Se encontraron los siguientes Contactos");
			mensajes.add("Todo salio bien");
			dto.setEstado(true);
			dto.setMensaje(mensajes);
			dto.setData(listaContacto);
		}		
		return dto;

	}
	@GetMapping("/Contacto/{id}")
	public RespuestaDto<Contacto> buscarPorId(@PathVariable("id") Long id){
		if(service.existe(id)) {
			Contacto contacto = new Contacto();
			contacto = service.mostrarPorId(id);
			RespuestaDto<Contacto> dto;
			dto = new RespuestaDto<Contacto>(true, "OK", contacto);
			return dto;
		}else {			
			return new RespuestaDto<Contacto>(false, "No existen contactos con el id ", null);
		}


	}
	

	@PostMapping("/api/contacto")
    public RespuestaDto<Contacto> crearNuevoNota(@RequestBody Contacto contacto) {
        if (service.existe(contacto.getId())) {
            return new RespuestaDto<>(false, "Error: El ID ya existe", null);
        }
        Contacto contactoGuardado = service.guardar(contacto); 
        return new RespuestaDto<>(true, "Contacto creado exitosamente", contactoGuardado);
        		}

	@PutMapping("/Contacto")
	public RespuestaDto<Contacto> actualizar(@RequestBody Contacto contactoDesdeElPostman){
		if(service.existe(contactoDesdeElPostman.getId())) {
			return new RespuestaDto<Contacto>(true, "Contacto actualizado con exito", service.guardar(contactoDesdeElPostman));
		}else {
			return new RespuestaDto<Contacto>(false, "No se encontró el ID " + contactoDesdeElPostman.getId().toString(), null);
		}		
	}
	@DeleteMapping("/Contacto/{ideliminar}")
	public RespuestaDto<?> eliminar(@PathVariable("ideliminar") Long id){
		if(service.existe(id)) {
			service.eliminarPorId(id);
			return new RespuestaDto<>(true, "Elemento eliminado el ID: " + id.toString(), null);
		}else {
			return new RespuestaDto<>(false, "No se encontró el ID " + id.toString(), null);
		}

	}

}

