/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package py.com.itx.sistema.interaccion;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import py.com.itx.sistema.usuario.Usuario;



@WebServlet(name = "Interaccion_Elemento_Modulo", 
        urlPatterns = {"/Interaccion/Elemento/Modulo"})


public class Interaccion_Elemento_Modulo extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, Exception  {

      
         
        if (request.getSession().getAttribute("SessionUsuario") == null)
        {        
            response.sendRedirect("../login.jspx");  
         }
               
        
        Usuario usuario = new Usuario();
        usuario = usuario.getSession(request);
        
        Integer modulo = 0;
        if (request.getParameter("modulo") != null)
        {
            modulo = Integer.parseInt( request.getParameter("modulo"));       
        }        



        InteraccionDAO dao = new InteraccionDAO();
        List<Map<String, Object>> rows = dao.ElementosModulo(usuario.getUsuario(), modulo);                
        
        request.setAttribute("lista", rows);        
        request.getRequestDispatcher("/Interaccion/jspf/lista.jspx").include(request, response);    
        
        
        
        //response.sendRedirect("../Interaccion/Mostrar.jspx"); 
        
        
        
        
        /*
        else if (request.getRequestURI().equals( request.getContextPath()+"/Interaccion/Buscar.do") ) 
        {

            usuario = (Usuario) request.getSession().getAttribute("SessionUsuario");

            String StrBuscar = "";
            StrBuscar = request.getParameter("buscar");         
  
            List<Interaccion> componentes = controlAccion.buscar(usuario, StrBuscar);

            request.getSession().setAttribute("SessionInteraccionIndice", componentes);            
            response.sendRedirect("../Interaccion/Indice.jspx"); 
            
        }
           */    
        
       /*         
        if (request.getHeader("referer") == null)
        {
            response.sendRedirect("../login.jspx");    
        }
        else
        {        
            if (request.getRequestURI().equals( request.getContextPath()+"/Modulo/Listar.do") ) 
            {                                           
                ModuloListar control = new ModuloListar();
                control.ejecutar(request, response);                   
            }       
        }           
        */    
            
        
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Interaccion_Elemento_Modulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Interaccion_Elemento_Modulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}