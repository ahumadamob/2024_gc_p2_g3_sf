package gc._4.pr2.grupo3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Contactos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private  Long id;
private String idUsuario;
private String nombreContacto;
private String gmailContacto;
private String numeroContacto;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(String idUsuario) {
	this.idUsuario = idUsuario;
}
public String getNombreContacto() {
	return nombreContacto;
}
public void setNombreContacto(String nombreContacto) {
	this.nombreContacto = nombreContacto;
}
public String getGmailContacto() {
	return gmailContacto;
}
public void setGmailContacto(String gmailContacto) {
	this.gmailContacto = gmailContacto;
}
public String getNumeroContacto() {
	return numeroContacto;
}
public void setNumeroContacto(String numeroContacto) {
	this.numeroContacto = numeroContacto;
} 

}
