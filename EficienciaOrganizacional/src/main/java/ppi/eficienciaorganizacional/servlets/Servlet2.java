
package ppi.eficienciaorganizacional.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ppi.eficienciaorganizacional.entidades.RegistrosActividades;

public class Servlet2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
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
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
