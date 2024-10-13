package gc._4.pr2.grupo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo3.entity.Evento;
import gc._4.pr2.grupo3.service.IEventoService;

@RestController 

public class EventoController {

    @Autowired

    private IEventoService service;

    @GetMapping("/evento")
    public List<Evento> motrarTodosLosEvento(){
        return service.mostrarTodo();

    }

    @GetMapping("/evento/{id}")
    public Evento mostrarEventosPorId(@PathVariable("id") Long id){
        return service.mostrarPorId(id);

    }

    @PostMapping("/evento")
    public Evento crearNuevoEvento(@RequestBody Evento eventosDesdeElServicio){
        return service.guardar(eventosDesdeElServicio);

    }

    @PutMapping("/evento")
    public Evento actualizarNuevoEvento(@RequestBody Evento eventosDesdeElServicio){
        return service.guardar(eventosDesdeElServicio);

    }

    @DeleteMapping("/grupo{id}")
    public void borrarGrupo(@PathVariable("id") Long id){
        service.eliminarPorId(id);
    }
}
