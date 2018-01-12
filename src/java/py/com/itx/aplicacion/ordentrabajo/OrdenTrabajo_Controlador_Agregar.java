/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.ordentrabajo;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nebuleuse.ORM.Persistencia;
import py.com.itx.aplicacion.ordentrabajodetalle.OrdenTrabajoDetalle;
import py.com.itx.aplicacion.ordentrabajovalores.OrdenTrabajoValores;



@WebServlet(name = "OrdenTrabajo_Controlador_Agregar",
        urlPatterns = {"/OrdenTrabajo/Controlador/Agregar"})


public class OrdenTrabajo_Controlador_Agregar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html;charset=UTF-8");        
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();

            
        try
        {
            
            // detalles
            String transaccionOrdenTrabajoDetalles = "transaccionOrdenTrabajoDetalles";
            List<OrdenTrabajoDetalle> ordenesDetalles = new ArrayList<OrdenTrabajoDetalle>(); 
            ordenesDetalles = (List<OrdenTrabajoDetalle>) request.getSession().getAttribute(
                    transaccionOrdenTrabajoDetalles);
            
            
            // valores
            String transaccionOrdenTrabajoValores = "transaccionOrdenTrabajoValores";
            List<OrdenTrabajoValores> ordenesValores = new ArrayList<OrdenTrabajoValores>(); 
            ordenesValores = ( List<OrdenTrabajoValores>) request.getSession().getAttribute(
                    transaccionOrdenTrabajoValores );            
            

            // cabecera            
            OrdenTrabajo  ordenTrabajo = new OrdenTrabajo();
            Persistencia persistencia = new Persistencia();
            ordenTrabajo = (OrdenTrabajo) persistencia.extraerRegistro(request, ordenTrabajo);
            
            ordenTrabajo = (OrdenTrabajo) persistencia.insert(ordenTrabajo);
            
            
            // cargas las cuadriculas con for            
            for (OrdenTrabajoDetalle ordenesDetalle : ordenesDetalles) {                
                ordenesDetalle.setOrden( ordenTrabajo.getOrden_trabajo() );
                persistencia.insert(ordenesDetalle);
            }
            
            
            
            for (OrdenTrabajoValores ordenesValore : ordenesValores) {                
                ordenesValore.setOrden(ordenTrabajo.getOrden_trabajo() );
                persistencia.insert(ordenesValore);
            }
                        

            out.println(ordenTrabajo.getOrden_trabajo());      
            // fin 
            
            
            
            
            
        }
        
        
        
        catch (Exception ex) {
            
            System.out.println(ex.getMessage());     
            out.println(ex.getMessage());      
            
        }
        
        
        /*
        catch (SQLException sqlEx)
        {            
            Mensaje mensaje = new Mensaje();                             
            mensaje.setMensajeBase(sqlEx.getMessage());            
            request.getSession().setAttribute("SessionMensajes", mensaje);            
        } 
        */
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
