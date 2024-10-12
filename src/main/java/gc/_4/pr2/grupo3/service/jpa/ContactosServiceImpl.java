package gc._4.pr2.grupo3.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo3.entity.Contactos;
import gc._4.pr2.grupo3.repository.ContactosRepository;
import gc._4.pr2.grupo3.service.IContactosService;

@Service

public class ContactosServiceImpl implements IContactosService {

    @Autowired

    private ContactosRepository repo;

    @Override
    public List<Contactos> mostrarTodo() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public Contactos mostrarPorId(Long id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElse(null);
    }

    @Override
    public Contactos guardar(Contactos contactos) {
        // TODO Auto-generated method stub
        return repo.save(contactos);
    }

    @Override
    public void eliminarPorId(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }
}
