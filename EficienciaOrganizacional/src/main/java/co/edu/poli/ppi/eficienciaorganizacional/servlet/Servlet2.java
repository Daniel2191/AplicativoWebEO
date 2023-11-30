package co.edu.poli.ppi.eficienciaorganizacional.servlet;

import java.io.*;

import co.edu.poli.ppi.eficienciaorganizacional.entidades.RegistrosActividades;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet2 extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession(true);

        RegistrosActividades registro = (RegistrosActividades) sesion.getAttribute("registro");

        String formulario = request.getParameter("formulario");

        if(formulario.equals("nuevo")){

            request.getRequestDispatcher("jsp/nuevoservicio.jsp").forward(request, response);
        } else if(formulario.equals("crearRegistro")){
            String vararea = request.getParameter("area");
            String varentidad = request.getParameter("entidad");
            String vardescripcion = request.getParameter("descripcion");

            if(!(vardescripcion.trim().isEmpty()) && (vardescripcion != null)){

                registro.nuevoRegistro(Integer.parseInt(vararea), Integer.parseInt(varentidad), vardescripcion);
                registro = (RegistrosActividades) sesion.getAttribute("registro");
                request.setAttribute("registros", registro.getRegistros());
                request.getRequestDispatcher("jsp/servicios.jsp").forward(request, response);
            }else{
                String mensaje = "Debe ingresar una descripcion de la actividad";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("jsp/nuevoservicio.jsp").forward(request, response);
            }

        }else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
