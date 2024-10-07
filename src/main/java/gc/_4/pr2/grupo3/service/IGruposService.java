package gc._4.pr2.grupo3.service;

import java.util.List;

import gc._4.pr2.grupo3.entity.Grupos;

public interface IGruposService {
	
	List<Grupos>mostrarTodo();
	Grupos mostrarPorId(Long id);
	Grupos guardar(Grupos grupos);
	void eliminarPorId(Long id);

}
