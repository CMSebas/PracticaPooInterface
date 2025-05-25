package ec.edu.ups.poo.models;

public class Proveedor {
    private String nombre;
    private String cedula;
    private String empresa;
    private String ruc;

    public Proveedor(String nombre, String cedula, String empresa, String ruc) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.empresa = empresa;
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
}
