/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.facturaventadetalle;





/**
 *
 * @author hugo
 */
public class FacturaVentaDetalleSQL {
    
    
public String  ListaSimple ( Integer factura)
            throws Exception {
    
            String sql = "";        
            
            sql = " "+
            "   SELECT factura_detalle, factura, descripcion, cantidad, precio_unitario, \n" +
            "       sub_total, porcentaje0, porcentaje5, porcentaje10, impuesto, \n" +
            "	       cantidad_hoja\n" +
            "	  FROM public.facturas_detalle\n" +
            "	  where factura = " + factura ;

            
            return sql ;
             
    }              


    
}
