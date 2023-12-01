package co.edu.poli.ppi.eficienciaorganizacional.DAO;

import co.edu.poli.ppi.eficienciaorganizacional.modelo.Entidad;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOEntidad extends Conexion{

    public boolean guardar(Entidad ent) throws SQLException {
        try {
            String sql = "INSERT INTO ENTIDADES (NIT, NOMBRE, DIRECCION, TELEFONO, CONTRASEÑA)"
                    + "VALUES (?,?,?,?,?)";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, ent.getNit());
            ps.setString(2, ent.getNombre());
            ps.setString(3, ent.getDireccion());
            ps.setString(4, ent.getTelefono());
            ps.setString(5, ent.getPassword());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println();
        }

        return false;

    }
}
