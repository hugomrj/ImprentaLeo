/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.aplicacion.ordentrabajodetalle;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import nebuleuse.ORM.Conexion;
import nebuleuse.ORM.Secuencia;
import nebuleuse.ORM.xml.Global;
import nebuleuse.util.Lista;
import py.com.itx.aplicacion.cliente.ClienteSQL;
import py.com.itx.aplicacion.ordentrabajo.OrdenTrabajoSQL;

/**
 *
 * @author hugo
 */
public class OrdenTrabajoDetalleDAO {
    
        Conexion conexion = new Conexion();
        Statement  statement ;
        ResultSet resultset;  
        Lista lista ;
        Integer lineas = Integer.parseInt(new Global().getValue("lineasLista"));
        public Integer totalRegistros = 0;
        

    
    public OrdenTrabajoDetalleDAO ( ) throws IOException  {
        conexion.conectar();
        lista = new Lista();
    }
        

    public List<Map<String, Object>>  ListaSimple  ( Integer orden )
            throws Exception {

            statement = conexion.getConexion().createStatement();  
                    
            String sql = new OrdenTrabajoDetalleSQL().ListaSimple(orden);

            resultset = statement.executeQuery(sql);     

            return lista.resultsetToList(resultset ) ;     

    }      

    
    
    public ResultSet  rsListaSimple  ( Integer orden )
            throws Exception {

            statement = conexion.getConexion().createStatement();  
                    
            String sql = new OrdenTrabajoDetalleSQL().ListaSimple(orden);

            resultset = statement.executeQuery(sql);     

            return resultset ;     

    }      


    

    public List<Map<String, Object>>  OrdenFacturaPie  ( Integer orden )
            throws Exception {

            statement = conexion.getConexion().createStatement();  
                    
            String sql = new OrdenTrabajoDetalleSQL().OrdenFacturaPie(orden);

            resultset = statement.executeQuery(sql);     

            return lista.resultsetToList(resultset ) ;     

    }      
    
    
    
    
    
}


