package gc._4.pr2.grupo3.DTO;

import java.util.ArrayList;
import java.util.List;

public class ResponsiveDto<T> {
	
	    private boolean estado; // true exitoso
	    private List<String> mensaje;
	    private T data;
	    public boolean isEstado() {
	        return estado;
	    }


	    public ResponsiveDto(boolean estado, List<String> mensaje, T data) {
	        super();
	        this.estado = estado;
	        this.mensaje = mensaje;
	        this.data = data;
	    }

	    public ResponsiveDto(boolean estado, String mensaje, T data) {
	        super();
	        List<String> mensajes = new ArrayList<String>();
	        mensajes.add(mensaje);
	        this.estado = estado;
	        this.mensaje = mensajes;
	        this.data = data;
	    }

	    public ResponsiveDto() {
	    }

	    public void setEstado(boolean estado) {
	        this.estado = estado;
	    }
	    public List<String> getMensaje() {
	        return mensaje;
	    }
	    public void setMensaje(List<String> mensaje) {
	        this.mensaje = mensaje;
	    }
	    public T getData() {
	        return data;
	    }
	    public void setData(T data) {
	        this.data = data;
	    }


	
}
