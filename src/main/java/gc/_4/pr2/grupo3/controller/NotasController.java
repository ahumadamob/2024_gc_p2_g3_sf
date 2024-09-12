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

import gc._4.pr2.grupo3.entity.Notas;
import gc._4.pr2.grupo3.service.INotasService;

@RestController

public class NotasController {
	@Autowired
	private INotasService service;
	
	@GetMapping("/notas")
    public List<Notas> motrarTodosLosNotas(){
        return service.mostrarTodo();

    }

    @GetMapping("/notas/{id}")
    public Notas mostrarNotasPorId(@PathVariable("id") Long id){
        return service.mostrarPorId(id);

    }

    @PostMapping("/notas")
    public Notas crearNuevoNotas(@RequestBody Notas notasDesdeElServicio){
        return service.guardar(notasDesdeElServicio);

    }

    @PutMapping("/notas")
    public Notas actualizarNuevoNotas(@RequestBody Notas notasDesdeElServicio){
        return service.guardar(notasDesdeElServicio);

    }

    @DeleteMapping("/notas{id}")
    public void borrarnotas(@PathVariable("id") Long id){
        service.eliminarPorId(id);
    }

}
