package co.edu.poli.ppi.eficienciaorganizacional.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection conexion = null;

    public static Connection getConexion() throws Exception {
        // Carga el driver de la base de datos
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            System.out.println("Driver de ORACLE cargado");

            String nombreUsuario = "PPI_EO";
            String password = "98765";
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            conexion = DriverManager.getConnection(url, nombreUsuario, password);
            System.out.println("Conección establecida satisfactoriamente");

        } catch (ClassNotFoundException ex) {
            throw new Exception("El oracle driver no se encontro");

        } catch (SQLException ex){
            throw new Exception("Excepcion de SQL");
        }

        return conexion;
    }
}
