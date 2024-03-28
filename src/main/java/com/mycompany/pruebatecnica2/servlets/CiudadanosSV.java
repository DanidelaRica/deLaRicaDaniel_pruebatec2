
package com.mycompany.pruebatecnica2.servlets;

import com.mycompany.pruebatecnica2.logica.Ciudadano;
import com.mycompany.pruebatecnica2.logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CiudadanosSV", urlPatterns = {"/CiudadanosSV"})
public class CiudadanosSV extends HttpServlet {

    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CiudadanosSV</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CiudadanosSV at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Tomo datos del JSP
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        
        //Crea un nuevo objeto Ciudadano
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre(nombre);
        ciudadano.setApellido(apellido);
        
        //Se persiste el equipo en la BD
        control.crearCiudadano(ciudadano);
        
        
        response.sendRedirect("mensajeOkCiudadano.jsp");  
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
