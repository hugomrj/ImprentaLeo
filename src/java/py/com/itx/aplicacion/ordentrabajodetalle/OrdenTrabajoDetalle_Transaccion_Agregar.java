

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



@WebServlet(name = "OrdenTrabajoDetalle_Transaccion_Agregar",
        urlPatterns = {"/OrdenTrabajoDetalle/Transaccion/Agregar"})


public class OrdenTrabajoDetalle_Transaccion_Agregar extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        
        
        PrintWriter out = response.getWriter();     
        
        try
        {
                    
            String transaccionOrdenTrabajoDetalles = "transaccionOrdenTrabajoDetalles";
            List<OrdenTrabajoDetalle> ordenesDetalles = new ArrayList<OrdenTrabajoDetalle>(); 
            ordenesDetalles = (List<OrdenTrabajoDetalle>) request.getSession().getAttribute(
                    transaccionOrdenTrabajoDetalles);
            
            
            OrdenTrabajoDetalle  instancia = new OrdenTrabajoDetalle();
            Persistencia persistencia = new Persistencia();
            instancia = (OrdenTrabajoDetalle) persistencia.extraerRegistro(request, instancia);


            // condicional de donde cargar los porcentajes
            instancia.setPorcentaje0(0L);
            instancia.setPorcentaje5(0L);
            instancia.setPorcentaje10(0L);
            
            
            if (instancia.getImpuesto() == 10)
            {
                instancia.setPorcentaje10( instancia.getSub_total() );
            }
            else if (instancia.getImpuesto() == 5)
            {
                instancia.setPorcentaje5( instancia.getSub_total() );
            }
            else if (instancia.getImpuesto() == 0)
            {
                instancia.setPorcentaje0( instancia.getSub_total() );
            }
            
            
            ordenesDetalles.add(instancia);
            
            request.getSession().setAttribute( transaccionOrdenTrabajoDetalles, ordenesDetalles );
            
            out.println(ordenesDetalles.size());  
       
           
            
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
            Logger.getLogger(OrdenTrabajoDetalle_Transaccion_Agregar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrdenTrabajoDetalle_Transaccion_Agregar.class.getName()).log(Level.SEVERE, null, ex);
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
