package gc._4.pr2.grupo3.service;

import java.util.List;

import gc._4.pr2.grupo3.entity.Grupo;

public interface IGrupoService {
	
	List<Grupo>mostrarTodo();
	Grupo mostrarPorId(Long id);
	Grupo guardar(Grupo grupos);
	void eliminarPorId(Long id);
	boolean existe(Long id);
	
}
