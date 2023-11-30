package co.edu.poli.ppi.eficienciaorganizacional.servlet;

import java.io.*;

import co.edu.poli.ppi.eficienciaorganizacional.entidades.RegistrosActividades;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {
    private String message;

    public Servlet1() {
    }

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession(true);

        RegistrosActividades registro = (RegistrosActividades) sesion.getAttribute("registro");
        try {


        if(registro == null){
            registro = new RegistrosActividades();
            registro.nuevoRegistro(1, 1, "Se hizo la rendicion del aplicativo SUIT");
            registro.nuevoRegistro(2, 2, "Se realizo capacitacion de riesgos a los trabajadores");
            registro.nuevoRegistro(3, 3, "Se solicito usuario y contraseña para la plataforma MURC");
            registro.nuevoRegistro(1, 4, "Se hizo la rendicion del aplicativo SUIT");
            sesion.setAttribute("registro", registro);
        }

        String formulario = request.getParameter("formulario");

        if(formulario.equals("index")){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if(formulario.equals("servicios")){
            registro = (RegistrosActividades) sesion.getAttribute("registro");
            request.setAttribute("registros", registro.getRegistros());
            request.getRequestDispatcher("jsp/servicios.jsp").forward(request, response);
        } else if(formulario.equals("novedades")){
            request.getRequestDispatcher("jsp/novedades.jsp").forward(request, response);
        }else if(formulario.equals("contacto")){
            request.getRequestDispatcher("jsp/contacto.jsp").forward(request, response);
        } else if(formulario.equals("nosotros")){
            request.getRequestDispatcher("jsp/nosotros.jsp").forward(request, response);
        }else if(formulario.equals("ingresar")){
            request.getRequestDispatcher("jsp/ingresar.jsp").forward(request, response);
        }else if(formulario.equals("cotizacion")){
            request.getRequestDispatcher("jsp/cotizacion.jsp").forward(request, response);
        }else if(formulario.equals("ent")){
            request.getRequestDispatcher("jsp/loginEntidad.jsp").forward(request, response);
        }else if(formulario.equals("emp")) {
            request.getRequestDispatcher("jsp/loginEmpleado.jsp").forward(request, response);
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


    }

    public void destroy() {
    }
}