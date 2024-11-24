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
import gc._4.pr2.grupo3.entity.Usuario;
import gc._4.pr2.grupo3.service.IUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	//Buscar usuarios
	@GetMapping("/user")
	
	//public List<Usuario> motrarTodosLosUsuarios(){
		//return service.mostrarTodo();
		
	//}
	
	public RespuestaDto<List<Usuario>> buscarTodos(){
		List<Usuario> listaUsuario;
		listaUsuario = new ArrayList<Usuario>();
		listaUsuario = service.mostrarTodo();
		
		RespuestaDto<List<Usuario>> dto;
		dto = new RespuestaDto<List<Usuario>>();		
		
		if(listaUsuario.isEmpty()) {
			dto.setEstado(false);
			List<String> mensajes = new ArrayList<String>();
			mensajes.add("No se encontraron usuarios");
			dto.setMensaje(mensajes);
			dto.setData(null);
		}else {
			List<String> mensajes = new ArrayList<String>();
			mensajes.add("Se encontraron los siguientes usuarios");
			mensajes.add("Porque todo salio bien");
			dto.setEstado(true);
			dto.setMensaje(mensajes);
			dto.setData(listaUsuario);
		}		
		return dto;
		
	}
	
	//Buscar por ID
	@GetMapping("/user/{id}")
	
	//public Usuario mostrarUsuarioPorId(@PathVariable("id") Long id){
		//return service.mostrarPorId(id);
		
	//}
	
	public RespuestaDto<Usuario> buscarPorId(@PathVariable("id") Long id){
		if(service.existe(id)) {
			Usuario Usuario = new Usuario();
			Usuario = service.mostrarPorId(id);
			RespuestaDto<Usuario> dto;
			dto = new RespuestaDto<Usuario>(true, "OK", Usuario);
			return dto;
		}else {			
			return new RespuestaDto<Usuario>(false, "No existen usuarios con el id ", null);
		}
		
	}
	
	
	
	//Crear un nuevo usuario
	@PostMapping("/user")
	
	//public Usuario crearNuevoUsuario(@RequestBody Usuario usuarioDesdeElServicio){
		//return service.guardar(usuarioDesdeElServicio);
		
	//}
	
	public RespuestaDto<Usuario> crearNuevo(@RequestBody Usuario UsuarioDesdeElPostman){
		if(service.existe(UsuarioDesdeElPostman.getId())) {
			return new RespuestaDto<Usuario>(false, "Este ID ya existe", null);
		}else {
			return new RespuestaDto<Usuario>(true, "Usuario creado con exito", service.guardar(UsuarioDesdeElPostman));
		}
		
	}
	
	//Actualizar un usuario existente
	
	@PutMapping("/user/{idguardar}")
	//public Usuario actualizarNuevoUsuario(@RequestBody Usuario usuarioDesdeElServicio){
		//return service.guardar(usuarioDesdeElServicio);
		
	//}
	
	
	public RespuestaDto<Usuario> actualizar(@RequestBody Usuario usuarioDesdeElPostman){
		String mensaje;
		if(usuarioDesdeElPostman.getId()==null) {
			mensaje = "No se especificó el id";
		}else {
			mensaje = "No se encontró el ID " + usuarioDesdeElPostman.getId().toString();
		}
		if(service.existe(usuarioDesdeElPostman.getId())) {
		
			return new RespuestaDto<Usuario>(true, "Usuario actualizado con exito", service.guardar(usuarioDesdeElPostman));
		}else {
			return new RespuestaDto<Usuario>(false, mensaje, null);
		}		
	}
	
	
	//Eliminar un usuario
	
	@DeleteMapping("/user{ideliminar}")
	//public void borrarUsuario(@PathVariable("id") Long id){
		//service.eliminarPorId(id);
	//}
	
	
	public RespuestaDto<?> eliminar(@PathVariable("ideliminar") Long id){
		if(service.existe(id)) {
			service.eliminarPorId(id);
			return new RespuestaDto<>(true, "Elemento eliminado el ID: " + id.toString(), null);
		}else {
			return new RespuestaDto<>(false, "No se encontró el ID: " + id.toString(), null);
		}
		
	}
	
	
	
}
