package gc._4.pr2.grupo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo3.entity.Notas;

@RestController

public class NotasController {
	
	@GetMapping("/notas")

	Notas infoNotas() {
		
		Notas notas = new Notas();
		
		notas.setId(0);
		notas.setIdUsuario(null);
		notas.setTituloNota(null);
		notas.setContenidoNota(null);
		
		return notas;
	}
	
	

}
