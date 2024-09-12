package gc._4.pr2.grupo3.service;

import java.util.List;

import gc._4.pr2.grupo3.entity.Usuario;

public interface IUsuarioService {
	public List<Usuario>mostrarTodo();
	public Usuario mostrarPorId(Long Id);
	public Usuario guardar(Usuario usuario);
	public void eliminarPorId(Long Id);
}
