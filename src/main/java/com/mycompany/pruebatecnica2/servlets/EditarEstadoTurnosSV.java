package com.mycompany.pruebatecnica2.servlets;

import com.mycompany.pruebatecnica2.logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarEstadoTurnosSV", urlPatterns = {"/EditarEstadoTurnosSV"})
public class EditarEstadoTurnosSV extends HttpServlet {
    
    Controladora controladora = new Controladora();

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditarEstadoTurnosSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarEstadoTurnosSV at " + request.getContextPath() + "</h1>");
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
        // Obtener el ID del turno y el nuevo estado del formulario
        Long idTurno = Long.parseLong(request.getParameter("idTurno"));
        String nuevoEstado = request.getParameter("estado");

        // Llamar al método en la controladora para editar el estado del turno
        controladora.editarEstadoTurno(idTurno, nuevoEstado);

        // Redirigir
        response.sendRedirect("mensajeOkEditar.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
