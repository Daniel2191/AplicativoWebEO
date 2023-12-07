package co.edu.poli.ppi.eficienciaorganizacional.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet4", value = "/Servlet4")
public class Servlet4 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession(true);

            String formulario = request.getParameter("formulario");

            String varnivel = request.getParameter("nivel");

            String varcantidad = request.getParameter("cantidad");

            String varcorreo = request.getParameter("correo");

            String varnumero = request.getParameter("numero");

            if(formulario.equals("EnviarCotizacion")){
                if(!(varcantidad.trim().isEmpty()) && (varcantidad != null)){
                    if(numerico(varcantidad)){
                        if(!(varcorreo.trim().isEmpty()) && (varcorreo != null) || !(varnumero.trim().isEmpty()) && (varnumero != null)){
                            if(Double.parseDouble(varnivel) == 2 || Double.parseDouble(varcantidad) > 50){
                                String mensaje = "EL VALOR DEL CONTRATO PARA UNA EMPRESA CON ESTAS CARACTERISTICAS ES UN (1) MILLON PESOS AL MES";
                                request.setAttribute("mensaje", mensaje);
                                String mensaje1 = "En los proximos dias nos estaremos comunicando con su empresa para terminar la cotizacion.";
                                request.setAttribute("mensaje1", mensaje1);
                            }else if(Double.parseDouble(varcantidad) <= 10){
                                String mensaje = "EL VALOR DEL CONTRATO PARA UNA EMPRESA CON ESTAS CARACTERISTICAS ES DOS CIENTOS CINCUENTA (250) MIL PESOS AL MES";
                                request.setAttribute("mensaje", mensaje);
                                String mensaje1 = "En los proximos dias nos estaremos comunicando con su empresa para terminar la cotizacion.";
                                request.setAttribute("mensaje1", mensaje1);
                            }else if(Double.parseDouble(varcantidad) <= 50){
                                String mensaje = "EL VALOR DEL CONTRATO PARA UNA EMPRESA CON ESTAS CARACTERISTICAS ES QUINIENTOS (500) MIL PESOS AL MES";
                                request.setAttribute("mensaje", mensaje);
                                String mensaje1 = "En los proximos dias nos estaremos comunicando con su empresa para terminar la cotizacion.";
                                request.setAttribute("mensaje1", mensaje1);
                            }
                        }else{
                            String mensaje1 = "Debe ingresar al menos un medio para contactarse para cerrar la cotizacion.";
                            request.setAttribute("mensaje1", mensaje1);
                        }
                    }else{
                        String mensaje1 = "La cantidad de trabajadores/contratistas debe ser un valor numerico.";
                        request.setAttribute("mensaje1", mensaje1);
                    }
                }else{
                    String mensaje1 = "Debe ingresar la cantidad de trabajadores/contratistas en la empresa.";
                    request.setAttribute("mensaje1", mensaje1);
                }
                request.getRequestDispatcher("jsp/cotizacion.jsp").forward(request, response);
            }
        }

    }

    public boolean numerico(String strNum){
        try{
            Double.parseDouble(strNum);
        } catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
}
