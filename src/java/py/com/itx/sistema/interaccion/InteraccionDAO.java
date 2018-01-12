/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.itx.sistema.interaccion;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;


import java.util.List;
import java.util.Map;
import nebuleuse.ORM.Conexion;


import nebuleuse.util.Lista;


import nebuleuse.ORM.xml.Global;

import nebuleuse.util.Lista;


/**
 *
 * @author hugo
 */

public class InteraccionDAO {
    

        Conexion conexion = new Conexion();
        Statement  statement ;
        ResultSet resultset;  
        Lista lista ;

        Integer lineas = Integer.parseInt(new Global().getValue("lineasLista"));
        public Integer totalRegistros = 0;        

    
    
    public InteraccionDAO ( ) throws IOException  {
        conexion.conectar();
        lista = new Lista();
    }
    

    
/*
    public List<Interaccion> buscar(Usuario usuario, String StrBuscar) throws Exception {         
                      
            Secuencia<Interaccion> secuencia = new Secuencia<Interaccion>();         
            List<Interaccion> ListaInteracciones = new ArrayList<Interaccion>();         
           
	String strSQL = " SELECT sys_interacciones.interaccion, nombre_interaccion, url "
                        + " FROM sys_interacciones, "
                        + " ( "
                        + "     SELECT interaccion "
                        + "     FROM sys_usuarios_x_roles, sys_roles_x_interacciones "
                        + "     where sys_usuarios_x_roles.rol = sys_roles_x_interacciones.rol "
                        + "     and sys_usuarios_x_roles.usuario =  " + usuario.getUsuario().toString()
                        + " ) as t  "
                        + " WHERE nombre_interaccion iLIKE '%"+StrBuscar.trim()+"%'  "
                        + " and t.interaccion = sys_interacciones.interaccion "
                        + " group by sys_interacciones.interaccion, nombre_interaccion, url ";           
            
                        
            ListaInteracciones = secuencia.listaSimpleSQL(new Interaccion(), strSQL );     
            
            return ListaInteracciones;
            
    }
   */
    
    
    


    public List<Map<String, Object>>  ElementosModulo (Integer usuario, Integer modulo)
            throws Exception {
               
                statement = conexion.getConexion().createStatement();         
                
                String sql =  new InteraccionSQL().ElementosModulo(usuario, modulo);
                resultset = statement.executeQuery(sql);     
                
                
                return lista.resultsetToList(resultset ) ;
             
    }         


    /*        
     
    public List<Interaccion> mostrar(Usuario usuario, Modulo modulo) throws Exception {         
                      
            Secuencia<Interaccion> secuencia = new Secuencia<Interaccion>();         
            List<Interaccion> ListaInteracciones = new ArrayList<Interaccion>();         

            String strSQL =
                    " SELECT sys_interacciones.interaccion, nombre_interaccion, url "
                    + " FROM sys_interacciones, "
                    + " ( "
                    + "     SELECT interaccion "
                    + "     FROM sys_usuarios_x_roles, sys_roles_x_interacciones "
                    + "     where sys_usuarios_x_roles.rol = sys_roles_x_interacciones.rol "
                    + "     and sys_usuarios_x_roles.usuario =  " + usuario.getUsuario().toString()
                    + " ) as t "
                    + " WHERE t.interaccion = sys_interacciones.interaccion "
                    + " and sys_interacciones.modulo =  " + modulo.getModulo().toString() 
                    + " group by sys_interacciones.interaccion, nombre_interaccion, url, orden  "
                    + " order by sys_interacciones.orden" ;
            
                                          
            ListaInteracciones = secuencia.listaSimpleSQL(new Interaccion(), strSQL );     
            
            return ListaInteracciones;

    }
   

    */

    
    
    
    public List<Map<String, Object>>  Lista ( String buscar, Integer page )
            throws Exception {

            
            page = (page==0) ? 1 : page;
        
            page = (lineas * page) - lineas ;        
            String limite_offset = "  limit " + lineas + " "+ 
                    " offset " + page  ;
            
            statement = conexion.getConexion().createStatement();  
            
            String sql = new InteraccionSQL().Lista(buscar);
                    
               
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
        
    

    
}
