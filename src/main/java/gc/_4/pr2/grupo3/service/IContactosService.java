package gc._4.pr2.grupo3.service;

import java.util.List;

import gc._4.pr2.grupo3.entity.Contactos;

public interface IContactosService {

	List<Contactos>mostrarTodo();
	Contactos mostrarPorId(Long id);
	Contactos guardar(Contactos contactos);
	void eliminarPorId(Long id);
}
