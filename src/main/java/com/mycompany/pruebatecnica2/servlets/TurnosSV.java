package com.mycompany.pruebatecnica2.servlets;

import com.mycompany.pruebatecnica2.logica.Ciudadano;
import com.mycompany.pruebatecnica2.logica.Controladora;
import com.mycompany.pruebatecnica2.logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TurnosSV", urlPatterns = {"/TurnosSV"})
public class TurnosSV extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TurnosSV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TurnosSV at " + request.getContextPath() + "</h1>");
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

        // Obtener la lista de turnos desde la controladora
        List<Turno> turnos = controladora.traerTurnos();

        // Agregar la lista de turnos como un atributo al alcance de la solicitud
        request.setAttribute("turnos", turnos);

        // Redirigir de vuelta al formulario
        request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener datos desde el JSP
        String fechaIngresada = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");
        String idCiudadano = request.getParameter("id_ciudadano");

        try {
            // Verificar si el ID del ciudadano es válido
            if (idCiudadano != null && !idCiudadano.isEmpty()) {
                // Verificar si el ID del ciudadano corresponde a un ciudadano existente
                Ciudadano ciudadano = controladora.obtenerCiudadano(Long.parseLong(idCiudadano));
                if (ciudadano == null) {
                    // Si no se encuentra el ciudadano, redirigir a la página de error
                    response.sendRedirect("errorIdCiudadano.jsp");
                    return;
                }

                // Convertir la fecha
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = sdf.parse(fechaIngresada);

                // Crear nuevo Turno
                Turno turno = new Turno();
                turno.setFecha(fecha);
                turno.setDescripcion(descripcion);
                turno.setEstado("EN_ESPERA");
                System.out.println(turno.getEstado());
                // Mandar a persistir el turno
                controladora.crearTurno(turno, Long.parseLong(idCiudadano));

                // Redirigir
                request.getRequestDispatcher("mensajeOkTurno.jsp").forward(request, response);
            } else {
                // Si el ID del ciudadano es nulo o vacío, redirigir a la página de error
                response.sendRedirect("errorIdCiudadano.jsp");
            }
        } catch (ParseException | NumberFormatException ex) {
            // Manejar excepciones de parseo de fecha o número
            // Redirigir a una página de error
            response.sendRedirect("error.jsp");
        }
    }

    /*// Obtener datos desde el JSP
        String fechaIngresada = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");
        String idCiudadano = request.getParameter("id_ciudadano");
        

        try {
            //Convertir la fecha
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-mm-dd");
            Date fecha = sdf.parse(fechaIngresada);
            //Crear nuevo Turno
            Turno turno = new Turno();
            turno.setFecha(fecha);
            turno.setDescripcion(descripcion);
            turno.setEstado(Turno.EstadoTurno.EN_ESPERA);
            
            //Mandar a persistir el partido, enviado los IDs 
            controladora.crearTurno(turno, Long.parseLong(idCiudadano));
            System.out.println(idCiudadano);
            // Redirigir de vuelta al formulario
            request.getRequestDispatcher("mensajeOkTurno.jsp").forward(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(TurnosSV.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
