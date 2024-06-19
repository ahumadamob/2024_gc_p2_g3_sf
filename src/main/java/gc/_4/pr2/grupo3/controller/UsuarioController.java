package gc._4.pr2.grupo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo3.entity.Usuario;

@RestController

public class UsuarioController {
	
	@GetMapping("/usuario")
	public Usuario infoDeUsuario(){
		
		Usuario usuario =new Usuario();
		
		usuario.setId(null);
		usuario.setNombre(null);
		usuario.setGmail(null);
		usuario.setContraseña(null);
		
		return usuario;
		
	}

}
