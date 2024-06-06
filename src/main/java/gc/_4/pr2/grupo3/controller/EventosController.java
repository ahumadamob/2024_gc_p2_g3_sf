package gc._4.pr2.grupo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo3.entity.Eventos;

@RestController

public class EventosController {
	
@GetMapping ("/eventos")
	
	public Eventos infoDeEvento() {
		
		Eventos eventos = new Eventos();
		
		eventos.setId(null);
		eventos.setIdUsuario(null);
		eventos.setNombreEvento(null);
		eventos.setFechaHoraEvento(null);
		eventos.setUbicacionEvento(null);
		eventos.setDescripcionEvento(null);
		
		return eventos;
		
		
	}

}
