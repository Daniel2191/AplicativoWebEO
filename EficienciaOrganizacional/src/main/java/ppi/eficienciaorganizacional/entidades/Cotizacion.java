/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppi.eficienciaorganizacional.entidades;

/**
 *
 * @author danie
 */
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
