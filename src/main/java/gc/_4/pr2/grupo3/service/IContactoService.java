package gc._4.pr2.grupo3.service;

import java.util.List;

import gc._4.pr2.grupo3.entity.Contacto;

public interface IContactoService {
	List<Contacto>mostrarTodo();
	Contacto mostrarPorId(Long id);
	Contacto guardar(Contacto contactos);
	void eliminarPorId(Long id);
	boolean existe(Long id);
	
}
