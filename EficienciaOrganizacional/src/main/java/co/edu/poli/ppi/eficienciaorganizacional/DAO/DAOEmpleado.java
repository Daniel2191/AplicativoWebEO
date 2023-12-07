package co.edu.poli.ppi.eficienciaorganizacional.DAO;

import co.edu.poli.ppi.eficienciaorganizacional.modelo.Empleado;
import co.edu.poli.ppi.eficienciaorganizacional.modelo.Entidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOEmpleado extends Conexion {

    public boolean guardar(Empleado emp) throws SQLException {
        try {
            String sql = "INSERT INTO EMPLEADOS (DOCUMENTO, NOMBRE, "
                    + "P_APELLIDO, S_APELLIDO, TELEFONO, CONTRASEÑA, CORREO_PER, CARGO_CODIGO, ROL_CODIGO) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, emp.getDocumento());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getPriApellido());
            ps.setString(4, emp.getSegApellido());
            ps.setString(5, emp.getTelefono());
            ps.setString(6, emp.getPassword());
            ps.setString(7, emp.getCorreo());
            ps.setInt(8, emp.getCargo());
            ps.setInt(9, emp.getRol());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }

    public boolean actualizar(Empleado emp) throws SQLException {
        try {
            String sql = "UPDATE EMPLEADOS SET NOMBRE=?, P_APELLIDO=?, S_APELLIDO=?, TELEFONO=?, CORREO_PER=?, CARGO_CODIGO=?, ROL_CODIGO=? " +
                    "WHERE DOCUMENTO =? ";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getPriApellido());
            ps.setString(3, emp.getSegApellido());
            ps.setString(4, emp.getTelefono());
            ps.setString(5, emp.getCorreo());
            ps.setInt(6, emp.getCargo());
            ps.setInt(7, emp.getRol());
            ps.setInt(8, emp.getDocumento());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }

    public boolean eliminar(int id) throws SQLException {

        try {
            String sql = "DELETE FROM EMPLEADOS  WHERE DOCUMENTO = ? ";
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean login(Empleado emp) throws SQLException {
        try {
            String sql = "SELECT * FROM EMPLEADOS WHERE CONTRASEÑA=? AND CORREO_PER=?";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, emp.getPassword());
            ps.setString(2, emp.getCorreo());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }

    public int rol(String correo) throws SQLException {
        try {
            String sql = "SELECT * FROM EMPLEADOS WHERE CORREO_PER=?";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int c = rs.getInt("ROL_CODIGO");
                return c;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return 5;

    }
}
