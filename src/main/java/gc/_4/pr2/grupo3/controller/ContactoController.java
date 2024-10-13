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

import gc._4.pr2.grupo3.entity.Contacto;
import gc._4.pr2.grupo3.service.IContactoService;

@RestController

public class ContactoController {

    @Autowired

    private IContactoService service;

    @GetMapping("/contacto")
    public List<Contacto> motrarTodosLosContacto(){
        return service.mostrarTodo();

    }

    @GetMapping("/contacto/{id}")
    public Contacto mostrarContactosPorId(@PathVariable("id") Long id){
        return service.mostrarPorId(id);

    }

    @PostMapping("/contacto")
    public Contacto crearNuevoContacto(@RequestBody Contacto contactosDesdeElServicio){
        return service.guardar(contactosDesdeElServicio);

    }

    @PutMapping("/contacto")
    public Contacto actualizarNuevoContacto(@RequestBody Contacto contactosDesdeElServicio){
        return service.guardar(contactosDesdeElServicio);

    }

    @DeleteMapping("/contacto{id}")
    public void borrarContacto(@PathVariable("id") Long id){
        service.eliminarPorId(id);
    }
}


