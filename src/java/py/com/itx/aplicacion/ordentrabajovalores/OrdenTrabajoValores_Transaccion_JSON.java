/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.ordentrabajovalores;


import py.com.itx.aplicacion.ordentrabajodetalle.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hugo
 */
@WebServlet(name = "OrdenTrabajoValores_Transaccion_JSON", 
        urlPatterns = {"/OrdenTrabajoValores/Transaccion.json"})


public class OrdenTrabajoValores_Transaccion_JSON extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        
                
        PrintWriter out = response.getWriter();
        try 
        {
                        
            // controlar que exista la session
            String transaccionOrdenTrabajoValores = "transaccionOrdenTrabajoValores";
            
                   
            if ( request.getSession().getAttribute(transaccionOrdenTrabajoValores) != null)
            {        

                if ( request.getParameter("id") != null) 
                {

                    Integer id = Integer.parseInt(request.getParameter("id")) ;       

                    //String transaccionOrdenTrabajoDetalles = "transaccionOrdenTrabajoDetalles";
                    List<OrdenTrabajoValores> ordenesValores = new ArrayList<OrdenTrabajoValores>(); 
                    ordenesValores = (List<OrdenTrabajoValores>) request.getSession().getAttribute(
                            transaccionOrdenTrabajoValores);                
                                        
                    
                    try
                    {
                        OrdenTrabajoValores  instancia = new OrdenTrabajoValores();                
                        instancia = (OrdenTrabajoValores) ordenesValores.get(id);                

                        if (instancia == null)
                        {
                            out.println("[" +"]"); 
                        }
                        else
                        {
                            Gson gson = new Gson ();
                            String formatoJSON = gson.toJson(instancia);
                            out.println("[" +  formatoJSON  + "]");        
                        }         
                        
                    }
                    catch (IndexOutOfBoundsException e) 
                    {                        
                        out.println("[" + "]");        
                    }

                }    

            }
            
        
        } 
        finally 
        {
            out.close();
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(OrdenTrabajoValores_Transaccion_JSON.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrdenTrabajoValores_Transaccion_JSON.class.getName()).log(Level.SEVERE, null, ex);
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
