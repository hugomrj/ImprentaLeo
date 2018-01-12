/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package py.com.itx.sistema.usuario;


import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "Usuario_Controlador_Login", 
        urlPatterns = {
            "/Usuario/Login"           
        })




public class Usuario_Controlador_Login extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, Exception  {
                
        
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");        

                
        if (request.getHeader("referer") == null) {
            response.sendRedirect("../login.jspx");    
        }
                        
        request.getSession().setAttribute("SessionTheme", "themes/Blue.css");  
        
        String strCuenta = (String) request.getParameter("cuenta");
        String strClave = (String) request.getParameter("clave");

        Usuario usuario = new Usuario();
        usuario = Usuario.existeUsuario(strCuenta, strClave);
            
 

        if (usuario == null) 
        {           
            
            //Mensaje mensaje = new Mensaje();
            //mensaje.setEtiqueta("loginNOT");
            //mensaje.setTipo("error");             
            //mensaje.guardarInformacion();
            
            //request.getSession().setAttribute("SessionMensajes", mensaje);
            
            response.sendRedirect("../login.jspx");      
          
        }        
        else
        {
            
            
            request.getSession().setAttribute("SessionUsuario", usuario);  
            response.sendRedirect("../Menu/Indice.jspx");                     
            
        }            

     
    }
 
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Usuario_Controlador_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Usuario_Controlador_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}