/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.ordentrabajo;

import java.io.IOException;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import nebuleuse.ORM.Conexion;
import nebuleuse.ORM.xml.Global;
import nebuleuse.util.Lista;

/**
 *
 * @author hugom_000
 */


public class OrdenTrabajoDAO  {
        
        Conexion conexion = new Conexion();
        Statement  statement ;
        ResultSet resultset;  
        Lista lista ;
        Integer lineas = Integer.parseInt(new Global().getValue("lineasLista"));
        public Integer totalRegistros = 0;
        
    
    public OrdenTrabajoDAO ( ) throws IOException  {
        conexion.conectar();
        lista = new Lista();
    }

    
    public List<Map<String, Object>>  Lista ( String buscar, Integer page )
            throws Exception {

            
            page = (page==0) ? 1 : page;
        
            page = (lineas * page) - lineas ;        
            String limite_offset = "  limit " + lineas + " "+ 
                    " offset " + page  ;
            
            statement = conexion.getConexion().createStatement();  

            String sql = new OrdenTrabajoSQL().Lista(buscar, page);

            //String sql = new OrdenTrabajoSQL().Lista(buscar);
                     
            String sqlCount = " select count(*) as rows from ( "
                    + sql 
                    + " ) as C ";
               
            resultset = statement.executeQuery(sqlCount);                 
            if (resultset.next()){
                this.totalRegistros =  Integer.parseInt(resultset.getString(1));
            }                
                
            sql = sql + limite_offset ;
            resultset = statement.executeQuery(sql);     

            return lista.resultsetToList(resultset ) ;
             

    }              
    
    
        public List<Map<String, Object>>  RegistroOrden  ( Integer idregistro)                
            throws Exception {
                
            
                statement = conexion.getConexion().createStatement();         
                String sql = 
                    " 	SELECT \n" +
                    "	  ordenes_trabajo.orden_trabajo, \n" +
                    "	  ordenes_trabajo.fecha_recepcion, \n" +
                    "	  ordenes_trabajo.fecha_entrega, \n" +
                    "	  ordenes_trabajo.off_set, \n" +
                    "	  ordenes_trabajo.tipografica, \n" +
                    "	  ordenes_trabajo.factura, \n" +
                    "	  clientes.cedula, \n" +
                    "	  clientes.nombre, \n" +
                    "	  clientes.apellido, \n" +
                    "	  clientes.email, \n" +
                    "	  clientes.direccion, \n" +
                    "	  clientes.telefono, \n" +
                    "	  clientes.ruc, \n" +
                    "	  clientes.ciudad,\n" +
                    "	  clientes.cliente\n" +                        
                    "	FROM \n" +
                    "	  public.clientes, \n" +
                    "	  public.ordenes_trabajo\n" +
                    "	WHERE \n" +
                    "	  ordenes_trabajo.cliente = clientes.cliente\n" +
                    "	  and orden_trabajo =  " + idregistro  ;                
                
                resultset = statement.executeQuery(sql);     
                return lista.resultsetToList(resultset ) ;
             
    }            
    
}
















