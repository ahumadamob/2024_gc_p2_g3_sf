package gc._4.pr2.grupo3.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo3.entity.Eventos;
import gc._4.pr2.grupo3.repository.EventosRepository;
import gc._4.pr2.grupo3.service.IEventosService;

@Service

public class EventosServiceImpl implements IEventosService {

    @Autowired

    private EventosRepository repo;

    @Override
    public List<Eventos> mostrarTodo() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public Eventos mostrarPorId(Long id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElse(null);
    }

    @Override
    public Eventos guardar(Eventos eventos) {
        // TODO Auto-generated method stub
        return repo.save(eventos);
    }

    @Override
    public void eliminarPorId(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }
}