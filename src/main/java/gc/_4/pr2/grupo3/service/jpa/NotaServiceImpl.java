package gc._4.pr2.grupo3.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo3.entity.Nota;
import gc._4.pr2.grupo3.repository.NotaRepository;
import gc._4.pr2.grupo3.service.INotaService;

@Service

public class NotaServiceImpl implements INotaService {
	
	
	
	@Autowired
	
	private NotaRepository repo;
	
	@Override
	public List<Nota> mostrarTodo() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Nota mostrarPorId(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Nota guardar(Nota notas) {
		// TODO Auto-generated method stub
		return repo.save(notas);
	}

	@Override
	public void eliminarPorId(Long id) {
		repo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existe(Long id) {
		if(id==null) {
			return false;
		}else {
			return repo.existsById(id);
		}
	}

}
