/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.facturaventa;

import nebuleuse.ORM.Persistencia;
import py.com.itx.aplicacion.ordentrabajo.*;


/**
 *
 * @author hugo
 */
public class FacturaVentaSQL {
    
    
public String  Lista ( String buscar)
            throws Exception {
    
    
            if (buscar != ""){
                buscar = buscar.replaceAll(" ", "%");
            }
        
            String sql = "";    
    
            sql = " "+
"	SELECT \n" +
"	  facturas.factura, facturas.numero_factura, facturas.fecha_factura, \n" +
"	  facturas.cliente, facturas.gravada0, facturas.gravada5, \n" +
"	  facturas.gravada10, facturas.iva5, facturas.iva10, facturas.monto_total, \n" +
"	  facturas.usuario, facturas.forma_pago, clientes.cedula, \n" +
"	  clientes.nombre, clientes.apellido, clientes.email, \n" +
"	  clientes.direccion, clientes.telefono, clientes.ruc, \n" +
"	  clientes.ciudad \n" +
"	FROM \n" +
"	  public.facturas, \n" +
"	  public.clientes\n" +
"	WHERE \n" +
"	  clientes.cliente = facturas.cliente\n" +
"	  and   \n" +
"	  ( \n" +
"	  cast(nombre as text) ilike '%"+buscar+"%'\n" +
"	  or cast(numero_factura as text) ilike '%"+buscar+"%'\n" +
"	  )      \n" +
"	order by fecha_factura" ;
             
            
            return sql ;
                         

    }              




public String  Cabecera ( Integer codigo )
            throws Exception {
    
            String sql = "";    
            
            sql = " "+
            "   SELECT \n" +
            "	  facturas.factura,   facturas.fecha_factura,   facturas.numero_factura, \n" +
            "	  facturas.cliente,   facturas.gravada0,   facturas.gravada5,   facturas.gravada10, \n" +
            "	  facturas.iva5,   facturas.iva10,   facturas.monto_total,   facturas.usuario, \n" +
            "	  facturas.forma_pago,   facturas.orden_trabajo,   facturas.total_iva,   clientes.cedula, \n" +
            "	  clientes.nombre,   clientes.apellido,   clientes.email,   clientes.direccion,   clientes.telefono, \n" +
            "	  clientes.ruc,   clientes.ciudad\n" +
            "	FROM \n" +
            "	  public.facturas,   public.clientes\n" +
            "	WHERE \n" +
            "	  clientes.cliente = facturas.cliente\n" +
            "	  and facturas.factura = " + codigo;
            
            return sql ;
            
    }              

    
}
