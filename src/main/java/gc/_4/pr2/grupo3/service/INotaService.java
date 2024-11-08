package gc._4.pr2.grupo3.service;

import java.util.List;

import gc._4.pr2.grupo3.entity.Nota;

public interface INotaService  {
	
	List<Nota>mostrarTodo();
	Nota mostrarPorId(Long id);
	Nota guardar(Nota notas);
	void eliminarPorId(Long id);
	boolean existe(Long id);

}
