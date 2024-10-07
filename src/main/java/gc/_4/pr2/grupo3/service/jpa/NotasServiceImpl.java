package gc._4.pr2.grupo3.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo3.entity.Notas;
import gc._4.pr2.grupo3.repository.NotasRepository;
import gc._4.pr2.grupo3.service.INotasService;

@Service

public class NotasServiceImpl implements INotasService {
	
	
	
	@Autowired
	
	private NotasRepository repo;
	
	@Override
	public List<Notas> mostrarTodo() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Notas mostrarPorId(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Notas guardar(Notas notas) {
		// TODO Auto-generated method stub
		return repo.save(notas);
	}

	@Override
	public void eliminarPorId(Long id) {
		repo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}
