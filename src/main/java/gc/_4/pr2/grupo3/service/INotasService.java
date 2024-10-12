package gc._4.pr2.grupo3.service;

import java.util.List;

import gc._4.pr2.grupo3.entity.Notas;

public interface INotasService  {
	
	List<Notas>mostrarTodo();
	Notas mostrarPorId(Long id);
	Notas guardar(Notas notas);
	void eliminarPorId(Long id);

}
