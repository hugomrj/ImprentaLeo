/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.ordentrabajo;


/**
 *
 * @author hugo
 */
public class OrdenTrabajoSQL {
    

public String  Lista ( String buscar, Integer usuario)
            throws Exception {
    
            String sql = "";        
                
            sql = " "+
                "	SELECT \n" +
                "	  ordenes_trabajo.orden_trabajo, \n" +
                "	  ordenes_trabajo.fecha_recepcion, \n" +
                "	  ordenes_trabajo.fecha_entrega, \n" +
                "	  ordenes_trabajo.cliente, \n" +
                "	  clientes.nombre, \n" +
                "	  clientes.apellido, \n" +
                "	  ordenes_trabajo.factura\n" +
                "	FROM \n" +
                "	  public.ordenes_trabajo, \n" +
                "	  public.clientes\n" +
                "	WHERE \n" +
                "	  clientes.cliente = ordenes_trabajo.cliente\n" +
                "	  order by fecha_recepcion desc" ;
            
                return sql ;            
}


public String  Lista ( String buscar )
            throws Exception {
    
            String sql = "";        
            
            String condicionBusqueda = "";
            
            if (!(buscar.equals("")))
            {
                buscar = "%"+buscar+"%";
                buscar = buscar.replaceAll(" ", "%");
            
                condicionBusqueda = " "+ 
                "       and ( \n" +
                "       cast(orden_trabajo as text) ||  \n" +
                "       to_char(ordenes_trabajo.fecha_recepcion,'DD/MM/YYYY') ||  \n" +
                "       to_char(ordenes_trabajo.fecha_entrega,'DD/MM/YYYY') ||  \n" +
                "       cast(ordenes_trabajo.cliente as text)  ||                      \n" +
                "       cast(nombre as text)  ||  \n" +
                "       cast(apellido as text) ilike \n'" + buscar + "' " +
                "       )  ";
            }            
                        
            
            sql = " "+
                "        SELECT  \n" +
                "          ordenes_trabajo.orden_trabajo,   \n" +
                "          to_char(ordenes_trabajo.fecha_recepcion,'DD/MM/YYYY') as fecha_recepcion,\n" +
                "          to_char(ordenes_trabajo.fecha_entrega,'DD/MM/YYYY') as fecha_entrega,\n" +
                "          ordenes_trabajo.cliente,  \n" +
                "          clientes.nombre,  clientes.apellido,  ordenes_trabajo.factura 		  \n" +
                "        FROM  \n" +
                "          public.ordenes_trabajo,  public.clientes \n" +
                "        WHERE  \n" +
                "          clientes.cliente = ordenes_trabajo.cliente \n" +
                "\n" + condicionBusqueda + 
                "          order by ordenes_trabajo.fecha_recepcion desc       " ;
            
            

                return sql ;
             
    }              


    
}
