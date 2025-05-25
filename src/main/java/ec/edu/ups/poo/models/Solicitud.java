package ec.edu.ups.poo.models;

public class Solicitud {
    private String id;
    private String fecha;
    private String estado;
    private String detalles;

    public Solicitud(String id, String fecha, String estado, String detalles) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.detalles = detalles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
