package gc._4.pr2.grupo3.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo3.entity.Evento;
import gc._4.pr2.grupo3.repository.EventoRepository;
import gc._4.pr2.grupo3.service.IEventoService;

@Service

public class EventoServiceImpl implements IEventoService {

    @Autowired

    private EventoRepository repo;

    @Override
    public List<Evento> mostrarTodo() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public Evento mostrarPorId(Long id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElse(null);
    }

    @Override
    public Evento guardar(Evento eventos) {
        // TODO Auto-generated method stub
        return repo.save(eventos);
    }

    @Override
    public void eliminarPorId(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }
}