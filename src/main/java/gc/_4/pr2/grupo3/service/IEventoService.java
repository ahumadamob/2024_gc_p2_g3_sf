package gc._4.pr2.grupo3.service;

import java.util.List;

import gc._4.pr2.grupo3.entity.Evento;

public interface IEventoService {

	List<Evento>mostrarTodo();
	Evento mostrarPorId(Long id);
	Evento guardar(Evento eventos);
	void eliminarPorId(Long id);
	boolean exist(Long id);
}
