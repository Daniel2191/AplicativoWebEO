/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ppi.eficienciaorganizacional.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danie
 */
public class Servlet4 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
