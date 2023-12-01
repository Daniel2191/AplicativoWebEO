package co.edu.poli.ppi.eficienciaorganizacional.servlet;

import co.edu.poli.ppi.eficienciaorganizacional.DAO.DAOEntidad;
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
            }
            if (operacion.equals("editar")) {
                //editarCliente(req, resp);
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

            Entidad e = new Entidad(nit, nombre, direccion, telefono,pass);

            DAOEntidad daoEntidad = new DAOEntidad();

            if (daoEntidad.guardar(e)){
                System.out.println("Registro Exitoso!!");
                request.getRequestDispatcher("jsp/entidad.jsp").forward(request, response);
            }else {
                System.out.println("Error al guardar");
                request.getRequestDispatcher("registroEntidad.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
