/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.itx.aplicacion.ordentrabajo;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.com.itx.aplicacion.ordentrabajodetalle.OrdenTrabajoDetalle;
import py.com.itx.aplicacion.ordentrabajovalores.OrdenTrabajoValores;



@WebServlet(name = "OrdenTrabajo_Transaccion_Inicio",
        urlPatterns = {"/OrdenTrabajo/Transaccion/Inicio"})


public class OrdenTrabajo_Transaccion_Inicio extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
                String transaccionOrdenTrabajoDetalles = "transaccionOrdenTrabajoDetalles";                
                List<OrdenTrabajoDetalle> ordenesDetalles = new ArrayList<OrdenTrabajoDetalle>(); 
                
                
                String transaccionOrdenTrabajoValores = "transaccionOrdenTrabajoValores";                
                List<OrdenTrabajoValores> ordenesValores = new ArrayList<OrdenTrabajoValores>(); 
                
                
                //OrdenTrabajoDetalle o = new OrdenTrabajoDetalle();
                
                
                request.getSession().setAttribute( transaccionOrdenTrabajoDetalles, ordenesDetalles );
                request.getSession().setAttribute( transaccionOrdenTrabajoValores, ordenesValores );
        
                
                response.sendRedirect("../../OrdenTrabajo/Nuevo.jspx");  
        
        
                
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(OrdenTrabajo_Transaccion_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(OrdenTrabajo_Transaccion_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
