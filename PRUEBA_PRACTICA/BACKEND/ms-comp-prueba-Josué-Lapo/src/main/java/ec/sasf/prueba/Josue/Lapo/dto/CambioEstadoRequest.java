package ec.sasf.prueba.Josue.Lapo.dto;

public class CambioEstadoRequest {

    private String nuevoEstado;

    public CambioEstadoRequest() {
    }

    public CambioEstadoRequest(String nuevoEstado) {
        this.nuevoEstado = nuevoEstado;
    }
    public String getNuevoEstado() {
        return nuevoEstado;
    }
    public void setNuevoEstado(String nuevoEstado) {
        this.nuevoEstado = nuevoEstado;
    }
}
