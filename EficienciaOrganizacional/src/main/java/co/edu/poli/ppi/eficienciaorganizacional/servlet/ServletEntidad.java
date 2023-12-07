package co.edu.poli.ppi.eficienciaorganizacional.servlet;

import co.edu.poli.ppi.eficienciaorganizacional.DAO.DAOEmpleado;
import co.edu.poli.ppi.eficienciaorganizacional.DAO.DAOEntidad;
import co.edu.poli.ppi.eficienciaorganizacional.modelo.Empleado;
import co.edu.poli.ppi.eficienciaorganizacional.modelo.Entidad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ServletEntidad", value = "/ServletEntidad")
public class ServletEntidad extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String operacion = req.getParameter("operacion");

        if (operacion != null) {
            if (operacion.equals("crear")) {
                GuardarEntidad(req, resp);
            }else if (operacion.equals("editar")) {
                actualizarEntidad(req, resp);
            }else if (operacion.equals("eliminar")) {
                eliminarEntidad(req, resp);
            }else if (operacion.equals("login")) {
                loginEntidad(req, resp);
            }
        }

    }

    private void GuardarEntidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Captura los valores que el empleado escribió en el formulario

            String nit = request.getParameter("nit");
            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String pass = request.getParameter("pass");
            String correo = request.getParameter("correo");

            Entidad e = new Entidad(nit, nombre, direccion, telefono,pass, correo);

            DAOEntidad daoEntidad = new DAOEntidad();

            if (daoEntidad.guardar(e)){
                System.out.println("Registro Exitoso!!");
                response.sendRedirect("jsp/entidad.jsp");
            }else {
                System.out.println("Error al guardar");
                response.sendRedirect("registroEntidad.jsp");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void actualizarEntidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Captura los valores que el empleado escribió en el formulario

            String nit = request.getParameter("nit");
            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String pass = request.getParameter("pass");
            String correo = request.getParameter("correo");

            Entidad e = new Entidad(nit, nombre, direccion, telefono,pass, correo);

            DAOEntidad daoEntidad = new DAOEntidad();

            if (daoEntidad.actualizar(e)){
                System.out.println("Actualización Exitoso!!");

                response.sendRedirect("jsp/entidad.jsp");
            }else {
                System.out.println("Error al actualizar");
                response.sendRedirect("registroEntidad.jsp");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void eliminarEntidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Captura los valores que el empleado escribió en el formulario

            String id = request.getParameter("id");

            DAOEntidad daoEntidad = new DAOEntidad();

            if (daoEntidad.eliminar(id)){
                System.out.println("Registro Eliminado");
                response.sendRedirect("jsp/entidad.jsp");
            }else {
                System.out.println("Error al eliminar");
                response.sendRedirect("jsp/entidad.jsp");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void loginEntidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Captura los valores que el empleado escribió en el formulario

            String pass = request.getParameter("pass");
            String correo = request.getParameter("correo");
            Entidad e = new Entidad(pass, correo);

            DAOEntidad daoEntidad = new DAOEntidad();

            if (daoEntidad.login(e)){
                System.out.println("Ingreso exitoso");
                response.sendRedirect("index.jsp");
            }else {
                System.out.println("Error al eliminar");
                response.sendRedirect("../jsp/loginEntidad.jsp.jsp");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
