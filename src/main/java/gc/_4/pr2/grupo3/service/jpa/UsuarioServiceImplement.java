package gc._4.pr2.grupo3.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo3.entity.Usuario;
import gc._4.pr2.grupo3.repository.UsuarioRepository;
import gc._4.pr2.grupo3.service.IUsuarioService;

@Service
public class UsuarioServiceImplement implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	public List<Usuario> mostrarTodo() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Usuario mostrarPorId(Long Id) {
		// TODO Auto-generated method stub
		return repo.findById(Id).orElse(null);
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		return repo.save(usuario);
	}

	@Override
	public void eliminarPorId(Long Id) {
		repo.deleteById(Id);
		// TODO Auto-generated method stub
	
	}

}
