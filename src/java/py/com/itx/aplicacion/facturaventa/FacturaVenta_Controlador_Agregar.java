/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.facturaventa;



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
import py.com.itx.aplicacion.facturaventadetalle.FacturaVentaDetalle;
import py.com.itx.aplicacion.ordentrabajodetalle.OrdenTrabajoDetalle;



@WebServlet(name = "FacturaVenta_Controlador_Agregar",
        urlPatterns = {"/FacturaVenta/Controlador/Agregar"})


public class FacturaVenta_Controlador_Agregar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html;charset=UTF-8");        
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();

            
        try
        {
            
            
            // detalles
            String transaccionFacturaVenta_Detalles = "facturaDetalles";
            List<FacturaVentaDetalle> facturaDetalles = new ArrayList<FacturaVentaDetalle>();                         
            facturaDetalles = (List<FacturaVentaDetalle>) request.getSession().getAttribute(
                    transaccionFacturaVenta_Detalles);            
            
            
            

            // cabecera            
            FacturaVenta  factura_venta = new FacturaVenta();
            Persistencia persistencia = new Persistencia();
            factura_venta = (FacturaVenta) persistencia.extraerRegistro(request, factura_venta);
                    
            factura_venta = (FacturaVenta) persistencia.insert(factura_venta);
            
            
            
            FacturaVentaDAO facturaDAO = new FacturaVentaDAO();
            facturaDAO.FacturaVenta_numero_factura( factura_venta.getFactura()  );
            
            
            
            // cargar detalles   

            // cargas las cuadriculas con for            
            for (FacturaVentaDetalle fd : facturaDetalles) {      
                fd.setFactura( factura_venta.getFactura() );
                persistencia.insert(fd);
            }
      
            
    
            request.getSession().removeAttribute(transaccionFacturaVenta_Detalles);
            out.println(factura_venta.getFactura());      
            
            
        }
        
        
        
        catch (Exception ex) {
            
            System.out.println(ex.getMessage());     
            out.println(ex.getMessage());      
            
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
