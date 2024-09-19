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

import gc._4.pr2.grupo3.entity.Contactos;
import gc._4.pr2.grupo3.service.IContactosService;

@RestController

public class ContactosController {

    @Autowired

    private IContactosService service;

    @GetMapping("/contacto")
    public List<Contactos> motrarTodosLosContacto(){
        return service.mostrarTodo();

    }

    @GetMapping("/contacto/{id}")
    public Contactos mostrarContactosPorId(@PathVariable("id") Long id){
        return service.mostrarPorId(id);

    }

    @PostMapping("/contacto")
    public Contactos crearNuevoContacto(@RequestBody Contactos contactosDesdeElServicio){
        return service.guardar(contactosDesdeElServicio);

    }

    @PutMapping("/contacto")
    public Contactos actualizarNuevoContacto(@RequestBody Contactos contactosDesdeElServicio){
        return service.guardar(contactosDesdeElServicio);

    }

    @DeleteMapping("/contacto{id}")
    public void borrarContacto(@PathVariable("id") Long id){
        service.eliminarPorId(id);
    }
}


