package gc._4.pr2.grupo3.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo3.entity.Contacto;
import gc._4.pr2.grupo3.repository.ContactoRepository;
import gc._4.pr2.grupo3.service.IContactoService;

@Service

public class ContactoServiceImpl implements IContactoService {

    @Autowired

    private ContactoRepository repo;

    @Override
    public List<Contacto> mostrarTodo() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public Contacto mostrarPorId(Long id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElse(null);
    }

    @Override
    public Contacto guardar(Contacto contactos) {
        // TODO Auto-generated method stub
        return repo.save(contactos);
    }

    @Override
    public void eliminarPorId(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }
}
