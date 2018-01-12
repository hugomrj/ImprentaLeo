/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.ordentrabajovalores;


/**
 *
 * @author hugo
 */
public class OrdenTrabajoValoresSQL {
    
    
public String  ListaSimple ( Integer orden)
            throws Exception {
    
            String sql = "";        
             
            sql = " "+
                "  SELECT id, orden, tam_ancho, tam_largo, corte_ancho, corte_largo, descripcion, \n" +
                "       pliegos, sale, cantidad_pedido\n" +
                "  FROM public.ordenes_trabajos_valores\n" +
                "  where orden = " + orden ;

            return sql ;
             
    }              




    
}
