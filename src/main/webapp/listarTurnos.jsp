<%@page import="java.io.IOException"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.pruebatecnica2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listado de Turnos</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class = "col-8">
                    <h1 class="text-center">Listado de Turnos</h1>
                    <table class="table table-bordered mt-4">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Fecha</th>
                                <th>Descripción</th>
                                <th>Estado</th>
                                <th>ID Ciudadano</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iterar sobre la lista de turnos y mostrar cada turno -->
                            <% for (Turno turno : (List<Turno>) request.getAttribute("turnos")) {%>
                            <tr>
                                <td><%= turno.getId()%>
                                    <form action="EliminarTurnosSV" method="post" style="display: inline;">
                                        <!-- Campo oculto para pasar el ID del turno -->
                                        <input type="hidden" name="idTurno" value="<%= turno.getId()%>">

                                        <button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
                                    </form>
                                </td>
                                <td><%= turno.getFechaLocalDate()%></td>
                                <td><%= turno.getDescripcion()%></td>   
                                <td>
                                    <!-- Estado del turno -->
                                    <%= turno.getEstado()%>
                                    <!-- Botón de edición -->
                                    <form action="editarTurno.jsp" method="post" style="display: inline;">
                                        
                                        <input type="hidden" name="idTurno" value="<%= turno.getId()%>">

                                        <button type="submit" class="btn btn-success btn-sm">Editar</button>
                                    </form>
                                </td>
                                <td><%= turno.getCiudadano().getId()%></td>                        
                            </tr>
                            <% }%>
                        </tbody>
                    </table>

                    <a href="index.jsp" class="btn btn-primary">Volver al inicio</a>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
