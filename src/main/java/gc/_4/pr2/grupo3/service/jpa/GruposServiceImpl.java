package gc._4.pr2.grupo3.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo3.entity.Grupos;
import gc._4.pr2.grupo3.repository.GruposRepository;
import gc._4.pr2.grupo3.service.IGruposService;

@Service

public class GruposServiceImpl implements IGruposService {
	
	@Autowired
	
	private GruposRepository repo;

	@Override
	public List<Grupos> mostrarTodo() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Grupos mostrarPorId(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Grupos guardar(Grupos grupos) {
		// TODO Auto-generated method stub
		return repo.save(grupos);
	}

	@Override
	public void eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
}
