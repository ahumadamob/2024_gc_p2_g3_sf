package gc._4.pr2.grupo3.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Grupo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
   private Long id;
   private String nombre;
   
   @OneToMany(mappedBy = "grupo")  // Relación uno a muchos con Usuario
   private Set<Usuario> usuarios;  // Un grupo puede tener varios usuarios

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
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
