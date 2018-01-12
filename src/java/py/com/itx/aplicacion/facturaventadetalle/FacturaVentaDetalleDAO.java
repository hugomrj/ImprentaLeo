/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.facturaventadetalle;




import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import nebuleuse.ORM.Conexion;
import nebuleuse.ORM.xml.Global;
import nebuleuse.util.Lista;
import py.com.itx.aplicacion.ordentrabajodetalle.OrdenTrabajoDetalleSQL;

/**
 *
 * @author hugo
 */
public class FacturaVentaDetalleDAO {
    
        Conexion conexion = new Conexion();
        Statement  statement ;
        ResultSet resultset;  
        Lista lista ;
        Integer lineas = Integer.parseInt(new Global().getValue("lineasLista"));
        public Integer totalRegistros = 0;
        

    
    public FacturaVentaDetalleDAO ( ) throws IOException  {
        conexion.conectar();
        lista = new Lista();
    }
        



    public List<Map<String, Object>>  ListaSimple  ( Integer factura )
            throws Exception {

            statement = conexion.getConexion().createStatement();  
                    
            String sql = new FacturaVentaDetalleSQL().ListaSimple(factura);

            resultset = statement.executeQuery(sql);     

            return lista.resultsetToList(resultset ) ;     

    }      

        
    
    
    
}
