package gc._4.pr2.grupo3.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Grupos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String idUsuario;
private String nombreGrupo;

@OneToMany (mappedBy= "grupos")
private Set<Eventos> grupos;

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
public String getNombreGrupo() {
	return nombreGrupo;
}
public void setNombreGrupo(String nombreGrupo) {
	this.nombreGrupo = nombreGrupo;
}
}
