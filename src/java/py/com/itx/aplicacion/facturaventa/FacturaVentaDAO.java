/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.facturaventa;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import nebuleuse.ORM.Conexion;
import nebuleuse.ORM.xml.Global;
import nebuleuse.util.Lista;


/**
 *
 * @author hugom_000
 */


public class FacturaVentaDAO  {
        
        Conexion conexion = new Conexion();
        Statement  statement ;
        ResultSet resultset;  
        Lista lista ;
        Integer lineas = Integer.parseInt(new Global().getValue("lineasLista"));
        public Integer totalRegistros = 0;
        
    
    public FacturaVentaDAO ( ) throws IOException  {
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
            String sql = new FacturaVentaSQL().Lista(buscar);
                    
               
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
    
    
        
    public void FacturaVenta_numero_factura ( Integer codigo ) {

        
            try {
                
                statement = conexion.getConexion().createStatement();
                String sql =
                        "   UPDATE public.facturas\n" +
                        "   SET numero_factura = factura\n" +
                        "   WHERE factura = " + codigo  ;
                     
                statement.executeUpdate(sql);
                
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(FacturaVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                
    }        
        
    
    

    public List<Map<String, Object>>  Cabecera  ( Integer id )
            throws Exception {

            statement = conexion.getConexion().createStatement();                      
            String sql = new FacturaVentaSQL().Cabecera(id);

            resultset = statement.executeQuery(sql);     
            return lista.resultsetToList(resultset ) ;     
    }      
    
        


    public Integer  isFactura_orden  ( Integer orden )
            throws Exception {

            Integer retornar = 0;
            
            statement = conexion.getConexion().createStatement();                      
            String sql = 
                    "	SELECT *\n" +
                    "	  FROM public.facturas\n" +
                    "	  where orden_trabajo = " + orden;


            
            resultset = statement.executeQuery(sql);     
            
            if (resultset.next()){                
                retornar = resultset.getInt("factura");                
            }
            
            return retornar ;     
    }      
    
        

        
    
    
    
    
}
















