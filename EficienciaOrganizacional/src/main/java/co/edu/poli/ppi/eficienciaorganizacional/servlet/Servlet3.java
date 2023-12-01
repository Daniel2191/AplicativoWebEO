package co.edu.poli.ppi.eficienciaorganizacional.servlet;

import co.edu.poli.ppi.eficienciaorganizacional.entidades.RegistrosActividades;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet3", value = "/Servlet3")
public class Servlet3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           /* HttpSession sesion = request.getSession(true);

            RegistrosActividades registro = (RegistrosActividades) sesion.getAttribute("registro");

            String formulario = request.getParameter("formulario");

            String varcodigo = request.getParameter("codigo");
            String varentidad = request.getParameter("entidad");
            String vardescripcion = request.getParameter("descripcion");

            if(formulario.equals("entidad")){
                String varentidad1 = request.getParameter("entidad1");
                registro.setEntidad(Integer.parseInt(varcodigo), Integer.parseInt(varentidad1), varentidad);
                varentidad = varentidad1;
            } else if(formulario.equals("descripcion")){
                registro.setDescripcion(Integer.parseInt(varcodigo), vardescripcion);
            }

            request.setAttribute("codigo", varcodigo);
            request.setAttribute("entidad", varentidad);
            request.setAttribute("descripcion", vardescripcion);

            request.getRequestDispatcher("jsp/editarservicio.jsp").forward(request, response);

            */
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
