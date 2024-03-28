package com.mycompany.pruebatecnica2.servlets;

import com.mycompany.pruebatecnica2.logica.Controladora;
import com.mycompany.pruebatecnica2.logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FiltrarTurnosSV", urlPatterns = {"/FiltrarTurnosSV"})
public class FiltrarTurnosSV extends HttpServlet {

    Controladora controladora = new Controladora();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FiltrarTurnosSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FiltrarTurnosSV at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros enviados por el formulario HTML
        String fechaString = request.getParameter("fecha");
        String estadoString = request.getParameter("estado");

        // Convertir la cadena de fecha a un objeto Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = dateFormat.parse(fechaString);
        } catch (ParseException e) {
            // Manejar la excepción si la cadena de fecha no se puede convertir correctamente
            e.printStackTrace();
        }

        // Llamar al método que realizará la consulta en la base de datos
        List<Turno> turnosFiltrados = controladora.filtrarTurnosPorFechaYEstado(fecha, estadoString);
        
        // Agregar la lista de turnos filtrados como un atributo al alcance de la solicitud
        request.setAttribute("turnosFiltrados", turnosFiltrados);

        // Redirigir a la página JSP para mostrar los resultados
        request.getRequestDispatcher("filtrarTurnos.jsp").forward(request, response);
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
