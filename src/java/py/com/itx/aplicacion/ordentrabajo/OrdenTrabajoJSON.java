/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.ordentrabajo;





import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nebuleuse.ORM.Persistencia;

/**
 * @author hugo
 */


@WebServlet(name = "OrdenTrabajoJSON", 
        urlPatterns = {"/OrdenTrabajo/Linea.json"})


public class OrdenTrabajoJSON extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
                
        PrintWriter out = response.getWriter();
        try 
        {
            
            if ( request.getParameter("id") != null) 
            {
                
                Integer codigo = Integer.parseInt(request.getParameter("id")) ;                       
                
                OrdenTrabajo instancia = new OrdenTrabajo();               
                Persistencia persistencia = new Persistencia();
                instancia = (OrdenTrabajo) persistencia.filtrarId(instancia, codigo);
                
                Gson gson = new Gson ();                
                String formatoJSON = gson.toJson( instancia );                
                
                if (formatoJSON.trim().endsWith("null") ) {
                    formatoJSON = "[]";
                }
                else{
                    formatoJSON = "["+formatoJSON+"]";
                }
                
                out.println(formatoJSON);            

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
            Logger.getLogger(OrdenTrabajoJSON.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrdenTrabajoJSON.class.getName()).log(Level.SEVERE, null, ex);
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
