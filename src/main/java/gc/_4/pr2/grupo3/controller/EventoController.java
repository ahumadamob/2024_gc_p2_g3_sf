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

import gc._4.pr2.grupo3.DTO.ResponsiveDto;
import gc._4.pr2.grupo3.entity.Evento;
import gc._4.pr2.grupo3.service.IEventoService;

@RestController 

public class EventoController {

	@Autowired
	private IEventoService service;
	
	//Buscar todos los elementos:
	@GetMapping("/evento")
	
	public ResponsiveDto<List<Evento>> buscarTodos(){
		List<Evento> listaEVENTO;
		listaEVENTO = new ArrayList<Evento>();
		listaEVENTO = service.mostrarTodo();

		ResponsiveDto<List<Evento>> dto;
		dto = new ResponsiveDto<List<Evento>>();		

		if(listaEVENTO.isEmpty()) {
			dto.setEstado(false);
			List<String> mensajes = new ArrayList<String>();
			mensajes.add("No se encontraron Eventos");
			dto.setMensaje(mensajes);
			dto.setData(null);
		}else {
			List<String> mensajes = new ArrayList<String>();
			mensajes.add("Se encontraron los siguientes Eventos");
			mensajes.add("Todo salio bien");
			dto.setEstado(true);
			dto.setMensaje(mensajes);
			dto.setData(listaEVENTO);
		}		
		return dto;

	}
	

	@GetMapping("/Evento/{id}")
	public ResponsiveDto<Evento> buscarPorId(@PathVariable("id") Long id){
		if(service.exist(id)) {
			Evento evento = new Evento();
			evento = service.mostrarPorId(id);
			ResponsiveDto<Evento> dto;
			dto = new ResponsiveDto<Evento>(true, "OK", evento);
			return dto;
		}else {			
			return new ResponsiveDto<Evento>(false, "No existen eventos con el id ", null);
		}

}
	


	
	@PostMapping("/api/evento")
    public ResponsiveDto<Evento> crearNuevoEvento(@RequestBody Evento evento) {
        if (service.exist(evento.getId())) {
            return new ResponsiveDto<>(false, "Error: El ID ya existe", null);
        }
        Evento eventoGuardado = service.guardar(evento); 
        return new ResponsiveDto<>(true, "Evento creada exitosamente", eventoGuardado);
	        }
	    


	

	@PutMapping("/Evento")
	public ResponsiveDto<Evento> actualizar(@RequestBody Evento eventoDesdeElPostman){
		if(service.exist(eventoDesdeElPostman.getId())) {
			return new ResponsiveDto<Evento>(true, "Evento actualizada con exito", service.guardar(eventoDesdeElPostman));
		}else {
			return new ResponsiveDto<Evento>(false, "No se encontró el ID" + eventoDesdeElPostman.getId().toString(), null);
	}
	}
	
	@DeleteMapping("/Evento/{ideliminar}")
	public ResponsiveDto<?> eliminar(@PathVariable("ideliminar") Long id){
		if(service.exist(id)) {
			service.eliminarPorId(id);
			return new ResponsiveDto<>(true, "Elemento eliminado el ID: " + id.toString(), null);
		}else {
			return new ResponsiveDto<>(false, "No se encontró el ID" + id.toString(), null);
		}

	}
}
