package co.edu.poli.ppi.eficienciaorganizacional.modelo;

public class Empleado {

    private int documento;
    private String nombre;
    private String priApellido;
    private String segApellido;
    private String telefono;
    private String correo;
    private String password;
    private int cargo;
    private int rol;

    public Empleado() {
    }

    public Empleado(int documento, String nombre, String priApellido, String segApellido, String telefono, String correo, String password, int cargo, int rol) {
        this.documento = documento;
        this.nombre = nombre;
        this.priApellido = priApellido;
        this.segApellido = segApellido;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.cargo = cargo;
        this.rol = rol;
    }

    public Empleado(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPriApellido() {
        return priApellido;
    }

    public void setPriApellido(String priApellido) {
        this.priApellido = priApellido;
    }

    public String getSegApellido() {
        return segApellido;
    }

    public void setSegApellido(String segApellido) {
        this.segApellido = segApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        correo = correo;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
