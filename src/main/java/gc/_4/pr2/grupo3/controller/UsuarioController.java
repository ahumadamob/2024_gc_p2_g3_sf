package gc._4.pr2.grupo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo3.entity.Usuario;
import gc._4.pr2.grupo3.service.IUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/user")
	public List<Usuario> motrarTodosLosUsuarios(){
		return service.mostrarTodo();
		
	}
	
	@GetMapping("/user/{id}")
	public Usuario mostrarUsuarioPorId(@PathVariable("id") Long id){
		return service.mostrarPorId(id);
		
	}
	
	@PostMapping("/user")
	public Usuario crearNuevoUsuario(@RequestBody Usuario usuarioDesdeElServicio){
		return service.guardar(usuarioDesdeElServicio);
		
	}
	
	@PutMapping("/user")
	public Usuario actualizarNuevoUsuario(@RequestBody Usuario usuarioDesdeElServicio){
		return service.guardar(usuarioDesdeElServicio);
		
	}
	
	@DeleteMapping("/user{id}")
	public void borrarUsuario(@PathVariable("id") Long id){
		service.eliminarPorId(id);
	}
	
}
