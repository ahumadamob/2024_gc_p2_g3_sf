package gc._4.pr2.grupo3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Notas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	private String idUsuario;
	private String tituloNota;
	private String contenidoNota;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getTituloNota() {
		return tituloNota;
	}
	public void setTituloNota(String tituloNota) {
		this.tituloNota = tituloNota;
	}
	public String getContenidoNota() {
		return contenidoNota;
	}
	public void setContenidoNota(String contenidoNota) {
		this.contenidoNota = contenidoNota;
	}
	
}
