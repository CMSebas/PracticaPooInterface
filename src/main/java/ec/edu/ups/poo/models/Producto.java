package ec.edu.ups.poo.models;

public class Producto {
    private String nombre;
    private String idProducto;
    private String tipoProducto;

    public Producto(String nombre, String idProducto, String tipoProducto) {
        this.nombre = nombre;
        this.idProducto = idProducto;
        this.tipoProducto = tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
