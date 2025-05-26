package ec.edu.ups.poo.models;

public class Proveedor extends Persona {
    private String ruc;
    private String razonSocial;

    public Proveedor() {}

    public Proveedor(int id, String nombre, String ruc, String empresa) {
        super(id, nombre);
        this.ruc = ruc;
        this.razonSocial = empresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmpresa() {
        return razonSocial;
    }

    public void setEmpresa(String empresa) {
        this.razonSocial = empresa;
    }


    @Override
    public String toString() {
        return super.toString() +
                "Ruc: " + ruc +
                "|     Razon Social :  " + razonSocial ;
    }
}
