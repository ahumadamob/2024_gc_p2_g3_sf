package gc._4.pr2.grupo3.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo3.entity.Grupo;
import gc._4.pr2.grupo3.repository.GrupoRepository;
import gc._4.pr2.grupo3.service.IGrupoService;

@Service

public class GrupoServiceImpl implements IGrupoService {
	
	@Autowired
	
	private GrupoRepository repo;

	@Override
	public List<Grupo> mostrarTodo() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Grupo mostrarPorId(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Grupo guardar(Grupo grupo) {
		// TODO Auto-generated method stub
		return repo.save(grupo);
	}

	@Override
	public void eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
}
