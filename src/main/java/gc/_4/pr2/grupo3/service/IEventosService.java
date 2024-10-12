package gc._4.pr2.grupo3.service;

import java.util.List;

import gc._4.pr2.grupo3.entity.Eventos;

public interface IEventosService {

	List<Eventos>mostrarTodo();
	Eventos mostrarPorId(Long id);
	Eventos guardar(Eventos eventos);
	void eliminarPorId(Long id);
}
