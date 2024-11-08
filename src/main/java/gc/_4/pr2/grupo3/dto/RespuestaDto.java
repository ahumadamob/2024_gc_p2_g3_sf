package gc._4.pr2.grupo3.dto;

import java.util.ArrayList;
import java.util.List;

public class RespuestaDto<T> {
	
    private boolean estado; // true exitoso
    private List<String> mensaje;
    private T data;
    public boolean isEstado() {
        return estado;
    }


    public RespuestaDto(boolean estado, List<String> mensaje, T data) {
        super();
        this.estado = estado;
        this.mensaje = mensaje;
        this.data = data;
    }

    public RespuestaDto(boolean estado, String mensaje, T data) {
        super();
        List<String> mensajes = new ArrayList();
        mensajes.add(mensaje);
        this.estado = estado;
        this.mensaje = mensajes;
        this.data = data;
    }

    public RespuestaDto() {
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