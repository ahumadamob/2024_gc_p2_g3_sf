package gc._4.pr2.grupo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo3.entity.Contactos;

@RestController
public class ContactosController {
	@GetMapping("/contactos")
public Contactos infoDeContactos() { 
	Contactos contactos= new Contactos ();
	contactos.setId(null);
	contactos.setIdUsuario(null);
	contactos.setNombreContacto(null);
	contactos.setGmailContacto(null);
	contactos.setNumeroContacto(null);
	return contactos;
}
}
