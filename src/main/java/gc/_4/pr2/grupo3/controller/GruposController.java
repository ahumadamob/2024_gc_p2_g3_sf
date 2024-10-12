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

import gc._4.pr2.grupo3.entity.Grupos;
import gc._4.pr2.grupo3.service.IGruposService;

@RestController

public class GruposController {

	@Autowired
	
	private IGruposService service;
	
	@GetMapping("/grupo")
    public List<Grupos> motrarTodosLosGrupo(){
        return service.mostrarTodo();

    }

    @GetMapping("/grupo/{id}")
    public Grupos mostrarGruposPorId(@PathVariable("id") Long id){
        return service.mostrarPorId(id);

    }

    @PostMapping("/grupo")
    public Grupos crearNuevoGrupo(@RequestBody Grupos gruposDesdeElServicio){
        return service.guardar(gruposDesdeElServicio);

    }

    @PutMapping("/grupo")
    public Grupos actualizarNuevoGrupo(@RequestBody Grupos gruposDesdeElServicio){
        return service.guardar(gruposDesdeElServicio);

    }

    @DeleteMapping("/grupo{id}")
    public void borrarGrupo(@PathVariable("id") Long id){
        service.eliminarPorId(id);
    }
}
