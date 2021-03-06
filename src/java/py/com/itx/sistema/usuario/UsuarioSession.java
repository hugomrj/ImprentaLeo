/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.sistema.usuario;


import java.io.IOException;

import java.io.PrintWriter;
 import javax.servlet.ServletException;


import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "UsuarioSession",
        urlPatterns = {"/Usuario/Session"})


public class UsuarioSession extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            response.setContentType("text/html;charset=UTF-8");        
            response.setCharacterEncoding("UTF-8");
            

            PrintWriter out = response.getWriter();
            //out.println("hola");      
       
            if ( request.getSession().getAttribute("SessionUsuario") != null)
            {        
                Usuario usuario = new Usuario();
                usuario = usuario.getSession(request);                
                out.println(usuario.getUsuario().toString().trim());     
            }
            
            // este se va a quedar para controlar las sessiones si no existe sale del sistema
                        
          //  PrintWriter out = response.getWriter();
       
            if ( request.getSession().getAttribute("SessionUsuario") == null)
            {        

                request.getSession().invalidate();
                response.sendRedirect("../");    


            }


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
