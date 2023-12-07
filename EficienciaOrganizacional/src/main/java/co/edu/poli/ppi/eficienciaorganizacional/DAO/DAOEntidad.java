package co.edu.poli.ppi.eficienciaorganizacional.DAO;

import co.edu.poli.ppi.eficienciaorganizacional.modelo.Empleado;
import co.edu.poli.ppi.eficienciaorganizacional.modelo.Entidad;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOEntidad extends Conexion{

    public boolean guardar(Entidad ent) throws SQLException {
        try {
            String sql = "INSERT INTO ENTIDADES (NIT, NOMBRE, DIRECCION, TELEFONO, CONTRASEÑA, ENT_CORREO)"
                    + "VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, ent.getNit());
            ps.setString(2, ent.getNombre());
            ps.setString(3, ent.getDireccion());
            ps.setString(4, ent.getTelefono());
            ps.setString(5, ent.getPassword());
            ps.setString(6, ent.getCorreo());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println();
        }

        return false;

    }

    public boolean actualizar(Entidad ent) throws SQLException {
        try {
            String sql = "UPDATE ENTIDADES SET NOMBRE=?, DIRECCION=?, TELEFONO=?, ENT_CORREO=?" +
                    "WHERE NIT =? ";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, ent.getNombre());
            ps.setString(2, ent.getDireccion());
            ps.setString(3, ent.getTelefono());
            ps.setString(4, ent.getCorreo());
            ps.setString(5, ent.getNit());


            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }

    public boolean eliminar(String id) throws SQLException {

        try {
            String sql = "DELETE FROM ENTIDADES  WHERE NIT = ? ";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean login(Entidad ent) throws SQLException {
        try {
            String sql = "SELECT * FROM ENTIDADES WHERE CONTRASEÑA=? AND ENT_CORREO=?";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, ent.getPassword());
            ps.setString(2, ent.getCorreo());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }

}
