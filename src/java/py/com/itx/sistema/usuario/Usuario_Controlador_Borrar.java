/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itx.sistema.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nebuleuse.ORM.Persistencia;



@WebServlet(name = "Usuario_Controlador_Borrar",
        urlPatterns = {"/Usuario/Controlador/Borrar"})



public class Usuario_Controlador_Borrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html;charset=UTF-8");    
            
            PrintWriter out = response.getWriter();    

        try
        {
            if ( request.getParameter("usuario") != null) 
            {
                Integer id = 0;
                id = Integer.parseInt(request.getParameter("usuario") );
                
                Usuario  instancia = new Usuario();            
                Persistencia persistencia = new Persistencia();
                instancia = (Usuario) persistencia.filtrarId(instancia ,id);
                instancia =  (Usuario) persistencia.delete(instancia);
                out.println("DeleteOK");                          
                

            }
            else{
                out.println("DeleteNOT"); 
            }
        }
        
        catch (Exception ex) {
            //Logger.getLogger(Persona_Controlador_Agregar.class.getName()).log(Level.SEVERE, null, ex);
            out.println(ex.getMessage()); 
            System.out.println( ex.getMessage());     
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
