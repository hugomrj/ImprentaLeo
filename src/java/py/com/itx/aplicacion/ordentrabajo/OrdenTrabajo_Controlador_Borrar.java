/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.ordentrabajo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nebuleuse.ORM.Persistencia;
import py.com.itx.aplicacion.facturaventa.FacturaVenta;
import py.com.itx.aplicacion.facturaventa.FacturaVentaDAO;




@WebServlet(name = "OrdenTrabajo_Controlador_Borrar",
        urlPatterns = {"/OrdenTrabajo/Controlador/Borrar"})


public class OrdenTrabajo_Controlador_Borrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html;charset=UTF-8");    
            
            PrintWriter out = response.getWriter();    

        try
        {
            if ( request.getParameter("orden_trabajo") != null) 
            {
                
                
                /*
                // controlar si existe factura
                if (true){ 
                  throw new Exception("La edad debe ser positiva");
                  
                }
                */
                
                
                
                Integer orden_trabajo = 0;
                orden_trabajo = Integer.parseInt(request.getParameter("orden_trabajo") );
                
                OrdenTrabajo  instancia = new OrdenTrabajo();            
                Persistencia persistencia = new Persistencia();
                
                instancia = (OrdenTrabajo) persistencia.filtrarId(instancia ,orden_trabajo);
                

                
                // antes de borrar controlar si existe relacionada a una factura
                FacturaVentaDAO controlfactura = new FacturaVentaDAO();
                Integer existeNro = controlfactura.isFactura_orden(instancia.getOrden_trabajo());
                
                if ( existeNro != 0 )
                {
                    
                    throw new Exception("No se puede borrar por que esta relacionada "
                            + "a la factura Nro: "+existeNro );
                }
                
                
                instancia = (OrdenTrabajo) persistencia.delete(instancia);
                out.println("DeleteOK");                          

            }
            
            else{
                out.println("DeleteNOT"); 
            }
            
        }
        
        catch (Exception ex) {
            //Logger.getLogger(Persona_Controlador_Agregar.class.getName()).log(Level.SEVERE, null, ex);
            out.println(ex.getMessage()); 
            System.out.println( ex.getMessage());     
        }
        

        

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
