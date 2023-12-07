package co.edu.poli.ppi.eficienciaorganizacional.entidades;

public class Cotizacion {

    private int codigo;
    private int nivelriesgo;
    private int cantidadcontratistas;
    private String correo;
    private String telefono;

    public Cotizacion (int cantidadcontratistas, int nivelriesgo, String correo, String telefono){
        this.codigo = 1000;
        this.cantidadcontratistas = cantidadcontratistas;
        this.nivelriesgo = nivelriesgo;
        this.correo = correo;
        this.telefono = telefono;
    }

}
