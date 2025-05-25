package ec.edu.ups.poo.models;

public class Empleado {
    private String nombre;
    private String cedula;
    private String cargo;
    private String departamento;

    public Empleado(String nombre, String cedula, String cargo, String departamento) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.cargo = cargo;
        this.departamento = departamento;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
