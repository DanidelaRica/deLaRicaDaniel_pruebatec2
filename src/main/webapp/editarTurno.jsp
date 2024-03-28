<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Estado de Turno</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="mt-4">Editar Estado de Turno</h1>
                    <form action="EditarEstadoTurnosSV" method="post">
                        <div class="form-group">
                            <label for="estado">Seleccione un nuevo estado:</label>
                            <select class="form-control" name="estado" id="estado">
                                <option value="EN_ESPERA">En Espera</option>
                                <option value="YA_ATENDIDO">Ya Atendido</option>
                            </select>
                        </div>
                        <!-- Campo oculto para pasar el ID del turno -->
                        <input type="hidden" name="idTurno" value="<%= request.getParameter("idTurno")%>">
                        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
