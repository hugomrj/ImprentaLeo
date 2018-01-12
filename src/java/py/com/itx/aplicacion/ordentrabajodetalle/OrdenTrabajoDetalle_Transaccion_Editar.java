

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package py.com.itx.aplicacion.ordentrabajodetalle;




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
import nebuleuse.ORM.Persistencia;




@WebServlet(name = "OrdenTrabajoDetalle_Transaccion_Editar",
        urlPatterns = {"/OrdenTrabajoDetalle/Transaccion/Editar"})


public class OrdenTrabajoDetalle_Transaccion_Editar extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        PrintWriter out = response.getWriter();     
        
        try
        {


            
                       
            String transaccionOrdenTrabajoDetalles = "transaccionOrdenTrabajoDetalles"; 

            if ( request.getSession().getAttribute(transaccionOrdenTrabajoDetalles) != null)
            {        

                if ( request.getParameter("id") != null) 
                {

                    String id = request.getParameter("id") ;       
                    


                    List<OrdenTrabajoDetalle> ordenesDetalles = new ArrayList<OrdenTrabajoDetalle>(); 
                    ordenesDetalles = (List<OrdenTrabajoDetalle>) request.getSession().getAttribute(
                            transaccionOrdenTrabajoDetalles);                
                    
                    ordenesDetalles.remove(Integer.parseInt(id));   
                    

                    
                    OrdenTrabajoDetalle  instancia = new OrdenTrabajoDetalle();
                    Persistencia persistencia = new Persistencia();
                    instancia = (OrdenTrabajoDetalle) persistencia.extraerRegistro(request, instancia);                    
                    
                    ordenesDetalles.add(Integer.parseInt(id), instancia);
                    
                    request.getSession().setAttribute( transaccionOrdenTrabajoDetalles, ordenesDetalles );
 
                    out.println(id);  
                }    

            }
            
        }
        
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
            out.println(ex.getMessage());      
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
            Logger.getLogger(OrdenTrabajoDetalle_Transaccion_Editar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrdenTrabajoDetalle_Transaccion_Editar.class.getName()).log(Level.SEVERE, null, ex);
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
