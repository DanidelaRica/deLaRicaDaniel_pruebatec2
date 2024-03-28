<%@page import="java.util.List"%>
<%@page import="com.mycompany.pruebatecnica2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Filtrado de Turnos</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class = "col-6">
                    <h2 class="mt-5 mb-4">Filtrado de Turnos</h2>
                    <form action="FiltrarTurnosSV" method="post">
                        <div class="form-group row">
                            <label for="fecha" class="col-sm-2 col-form-label">Fecha:</label>
                            <div class="col-sm-10">
                                <input type="date" id="fecha" name="fecha" class="form-control" required>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="estado" class="col-sm-2 col-form-label">Estado:</label>
                            <div class="col-sm-10">
                                <select id="estado" name="estado" class="form-control">
                                    <option value="EN_ESPERA">EN_ESPERA</option>
                                    <option value="YA_ATENDIDO">YA_ATENDIDO</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-10 offset-sm-2">
                                <button type="submit" class="btn btn-primary">Filtrar</button>
                            </div>
                        </div>
                    </form>

                    <% if (request.getAttribute("turnosFiltrados") != null) { %>
                    <h3>Turnos filtrados:</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Fecha</th>
                                <th>Descripción</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Turno turno : (List<Turno>) request.getAttribute("turnosFiltrados")) {%>
                            <tr>
                                <td><%= turno.getId()%></td>
                                <td><%= turno.getFechaLocalDate()%></td>
                                <td><%= turno.getDescripcion()%></td>
                                <td><%= turno.getEstado()%></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                    <% }%>
                    <a href="index.jsp" class="btn btn-primary">Volver al inicio</a>
                </div>
            </div>
        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>