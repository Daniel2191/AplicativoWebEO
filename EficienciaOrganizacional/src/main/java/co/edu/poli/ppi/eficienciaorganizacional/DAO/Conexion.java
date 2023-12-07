package co.edu.poli.ppi.eficienciaorganizacional.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    /*
    private static Connection conexion = null;

    public static Connection getConexion() throws Exception {
        // Carga el driver de la base de datos
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            String nombreUsuario = "us_PPI";
            String password = "98765";
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            conexion = DriverManager.getConnection(url, nombreUsuario, password);
            System.out.println("Conección establecida satisfactoriamente");

        } catch (ClassNotFoundException ex) {
            throw new Exception("El oracle driver no se encontro");

        } catch (SQLException ex){
            System.out.println(ex);
            throw new Exception("Excepcion de SQL");
        }

        return conexion;
    }

     */

    // Librería de MySQL
    private String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    private String database = "EOPPI";

    // Host
    private String hostname = "34.66.231.255";

    // Puerto
    private String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nombre de usuario
    private String username = "root";

    // Clave de usuario
    private String password = "@Admin123";

    private Connection conexion = null;
    public Connection getConexion(){

        try {
            Class.forName(driver);
            conexion= DriverManager.getConnection(url, username, password);
            System.out.println("Conección establecida satisfactoriamente");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return conexion;
    }
}
