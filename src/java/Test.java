


import java.util.List;
import java.util.Map;
import nebuleuse.ORM.Conexion;
import py.com.itx.aplicacion.ordentrabajo.OrdenTrabajoDAO;
import py.com.itx.sistema.interaccion.InteraccionDAO;
import py.com.itx.sistema.modulo.ModuloDAO;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nebuleuse.ORM.Conexion;
import nebuleuse.ORM.Persistencia;
import nebuleuse.ORM.Secuencia;
import py.com.itx.aplicacion.cliente.Cliente;
import py.com.itx.aplicacion.cliente.ClienteSQL;
import py.com.itx.aplicacion.facturaventa.FacturaVenta;
import py.com.itx.aplicacion.facturaventa.FacturaVentaDAO;
import py.com.itx.aplicacion.facturaventadetalle.FacturaVentaDetalle;
import py.com.itx.aplicacion.facturaventadetalle.FacturaVentaDetalleDAO;
import py.com.itx.aplicacion.ordentrabajo.OrdenTrabajo;
import py.com.itx.aplicacion.ordentrabajo.OrdenTrabajoDAO;
import py.com.itx.aplicacion.ordentrabajodetalle.OrdenTrabajoDetalle;
import py.com.itx.aplicacion.ordentrabajodetalle.OrdenTrabajoDetalleDAO;
import py.com.itx.aplicacion.ordentrabajovalores.OrdenTrabajoValores;
import py.com.itx.aplicacion.usuario_rol.UsuarioRolDAO;
import py.com.itx.aplicacion.usuario_rol.UsuarioRolSQL;
import py.com.itx.sistema.interaccion.InteraccionDAO;
import py.com.itx.sistema.interaccion.InteraccionSQL;
import py.com.itx.sistema.modulo.ModuloDAO;
import py.com.itx.sistema.rol.Rol;
import py.com.itx.sistema.rol.RolSQL;
import py.com.itx.sistema.rol_interaccion.RolInteraccionSQL;

import py.com.itx.sistema.usuario.Usuario;
import py.com.itx.sistema.usuario.UsuarioDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hugo
 */



public class Test {
    
    
    public static  void main(String[] args) throws Exception   {

    

        
        
        



    UsuarioDAO dao = new UsuarioDAO();
    List<Map<String, Object>> rows = dao.Lista("", 1);    

    
    }
    
    
    
}



