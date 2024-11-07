package gc._4.pr2.grupo3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String contraseña;
	@ManyToOne
	private Grupo grupo;
	//private boolean estaEnGrupo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	//public boolean isEstaEnGrupo() {
		//return estaEnGrupo;
	//}
	
	//public void setEstaEnGrupo(boolean estaEnGrupo) {
		//this.estaEnGrupo = estaEnGrupo;
	//}
	
	
}
