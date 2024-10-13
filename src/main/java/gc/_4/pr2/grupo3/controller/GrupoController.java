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

import gc._4.pr2.grupo3.entity.Grupo;
import gc._4.pr2.grupo3.service.IGrupoService;

@RestController

public class GrupoController {

	@Autowired
	
	private IGrupoService service;
	
	@GetMapping("/grupo")
    public List<Grupo> motrarTodosLosGrupo(){
        return service.mostrarTodo();

    }

    @GetMapping("/grupo/{id}")
    public Grupo mostrarGruposPorId(@PathVariable("id") Long id){
        return service.mostrarPorId(id);

    }

    @PostMapping("/grupo")
    public Grupo crearNuevoGrupo(@RequestBody Grupo grupoDesdeElServicio){
        return service.guardar(grupoDesdeElServicio);

    }

    @PutMapping("/grupo")
    public Grupo actualizarNuevoGrupo(@RequestBody Grupo grupoDesdeElServicio){
        return service.guardar(grupoDesdeElServicio);

    }

    @DeleteMapping("/grupo/{id}")
    public void borrarGrupo(@PathVariable("id") Long id){
        service.eliminarPorId(id);
    }
}
