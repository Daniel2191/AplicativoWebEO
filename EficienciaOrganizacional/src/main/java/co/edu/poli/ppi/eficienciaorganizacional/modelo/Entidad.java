package co.edu.poli.ppi.eficienciaorganizacional.modelo;

public class Entidad {

    private String nit;
    private String nombre;
    private String direccion;
    private String telefono;
    private String password;
    private String correo;

    public Entidad(String nit, String nombre, String direccion, String telefono, String password, String correo) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.password = password;
        this.correo = correo;
    }

    public Entidad(String password, String correo) {
        this.password = password;
        this.correo = correo;
    }

    public Entidad(){

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
