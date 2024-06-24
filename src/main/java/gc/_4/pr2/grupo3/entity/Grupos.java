package gc._4.pr2.grupo3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Grupos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
   private Long id;
   private String idUsuario;
   private String nombreGrupo;
   
   @ManyToOne
   @JoinColumn( name = "usuario")
   private Usuario usuario;
   
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
