/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.ordentrabajodetalle;



/**
 *
 * @author hugo
 */
public class OrdenTrabajoDetalleSQL {
    
    
public String  ListaSimple ( Integer orden)
            throws Exception {
    
            String sql = "";        
             
            sql = " "+
                "   SELECT id, cantidad, descripcion, precio_unitario, sub_total, orden, \n" +
                "       porcentaje0, porcentaje5, porcentaje10, impuesto, unidad, cantidad_hoja\n" +
                "  FROM public.ordenes_trabajo_detalles\n" +
                "  where orden = " + orden ;

            
            return sql ;
             
    }              


public String  OrdenFacturaPie ( Integer orden)
            throws Exception {
    
            String sql = "";        
             
            sql = " "+
        "   	select *, (iva5 + iva10) total_iva\n" +
        "	from (\n" +
        "	select *, (gravada0 + gravada5 + gravada10) monto_total,\n" +
        "	round((gravada5 / 21)) iva5,\n" +
        "	round((gravada10 / 11)) iva10\n" +
        "	from (\n" +
        "	SELECT orden,  sum(porcentaje0) as gravada0, sum(porcentaje5) gravada5, sum(porcentaje10) gravada10\n" +
        "	  FROM public.ordenes_trabajo_detalles\n" +
        "	  where orden = \n" + orden +
        "	   group by orden\n" +
        "	   ) as t1\n" +
        "	   ) as t2" ;

            
            return sql ;
             
    }              




    
}
