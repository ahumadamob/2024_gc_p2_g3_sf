package gc._4.pr2.grupo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo3.entity.Grupos;

@RestController

public class GruposController {
	@GetMapping("/grupos")
public Grupos infoDeGrupos() {
	Grupos grupos= new Grupos ();
	grupos.setId(null);
	grupos.setIdUsuario(null);
	grupos.setNombreGrupo(null);
	return grupos;
}
}
