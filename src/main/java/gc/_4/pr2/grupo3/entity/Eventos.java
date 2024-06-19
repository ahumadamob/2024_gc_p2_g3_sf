package gc._4.pr2.grupo3.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Eventos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String idUsuario;
	private String nombreEvento;
	private LocalDateTime fechaHoraEvento;
	private String ubicacionEvento;
	private String descripcionEvento;
	
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
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public LocalDateTime getFechaHoraEvento() {
		return fechaHoraEvento;
	}
	public void setFechaHoraEvento(LocalDateTime fechaHoraEvento) {
		this.fechaHoraEvento = fechaHoraEvento;
	}
	public String getUbicacionEvento() {
		return ubicacionEvento;
	}
	public void setUbicacionEvento(String ubicacionEvento) {
		this.ubicacionEvento = ubicacionEvento;
	}
	public String getDescripcionEvento() {
		return descripcionEvento;
	}
	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}
	
	

}
