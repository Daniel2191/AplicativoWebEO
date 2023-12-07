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
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "ServletEmpleado", value = "/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String operacion = req.getParameter("operacion");

        if (operacion != null) {
            if (operacion.equals("crear")) {
                GuardarEmpleado(req, resp);
            }else if (operacion.equals("editar")) {
                actualizarEmpleado(req, resp);
            }else if (operacion.equals("eliminar")) {
                eliminarEmpleado(req, resp);
            }else if (operacion.equals("login")) {
                loginEmpleado(req, resp);
            }
        }

    }

    private void GuardarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Captura los valores que el empleado escribió en el formulario

            int documento = Integer.parseInt(request.getParameter("documento"));
            String nombre = request.getParameter("nombre");
            String p_apellido = request.getParameter("p_apellido");
            String s_apellido = request.getParameter("s_apellido");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            int cargo = Integer.parseInt(request.getParameter("cargo"));
            int rol = Integer.parseInt(request.getParameter("rol"));
            String pass = request.getParameter("pass");

            Empleado e = new Empleado(documento, nombre, p_apellido, s_apellido,telefono, correo, pass, cargo, rol);

            DAOEmpleado daoEmpleado = new DAOEmpleado();

            if (daoEmpleado.guardar(e)){
                System.out.println("Registro Exitoso!!");
                response.sendRedirect("jsp/empleado.jsp");
            }else {
                System.out.println("Error al guardar");
                response.sendRedirect("registroEmpleado.jsp");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Captura los valores que el empleado escribió en el formulario

            int documento = Integer.parseInt(request.getParameter("documento"));
            String nombre = request.getParameter("nombre");
            String p_apellido = request.getParameter("p_apellido");
            String s_apellido = request.getParameter("s_apellido");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            int cargo = 201;
            int rol = 102;
            String pass = request.getParameter("pass");

            Empleado e = new Empleado(documento, nombre, p_apellido, s_apellido,telefono, correo, pass, cargo, rol);

            DAOEmpleado daoEmpleado = new DAOEmpleado();

            if (daoEmpleado.actualizar(e)){
                System.out.println("Actualizacion Exitoso!!");
                response.sendRedirect("jsp/empleado.jsp");
            }else {
                System.out.println("Error al atualizar");
                response.sendRedirect("jsp/editEmpleado.jsp");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Captura los valores que el empleado escribió en el formulario

            int id = Integer.parseInt(request.getParameter("id"));

            DAOEmpleado daoEmpleado = new DAOEmpleado();

            if (daoEmpleado.eliminar(id)){
                System.out.println("Registro Eliminado");
                response.sendRedirect("jsp/empleado.jsp");
            }else {
                System.out.println("Error al eliminar");
                response.sendRedirect("jsp/empleado.jsp");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void loginEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Captura los valores que el empleado escribió en el formulario
            HttpSession nueva_session = request.getSession();


            String pass = request.getParameter("pass");
            String correo = request.getParameter("correo");
            Empleado e = new Empleado(pass, correo);

            DAOEmpleado daoEmpleado = new DAOEmpleado();

            if (daoEmpleado.login(e)){
                int rol=daoEmpleado.rol(correo);
                nueva_session.setAttribute("rol", rol);
                System.out.println(rol);
                System.out.println("Ingreso exitoso");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else {
                System.out.println("Error al INGRESAR");
                response.sendRedirect("../jsp/loginEmpleado.jsp");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
