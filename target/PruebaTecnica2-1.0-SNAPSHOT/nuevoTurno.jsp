<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agregar Nuevo Turno - Sistema de Gestión de Turnos</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class = "col-5">
                    <h1>Agregar Nuevo Turno</h1>
                    <form action="TurnosSV" method="post">
                        <div class="form-group">
                            <label for="ciudadano">Id ciudadano:</label>
                            <input type="text" class="form-control" id="id_ciudadano" name="id_ciudadano">
                        </div>                
                        <div class="form-group">
                            <label for="fecha">Fecha del Turno:</label>
                            <input type="date" class="form-control" id="fecha" name="fecha" required>
                        </div>
                        <div class="form-group">
                            <label for="descripcion">Descripción del Trámite:</label>
                            <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Agregar Turno</button>
                    </form>
                    <a href="index.jsp" class="btn btn-secondary mt-3">Volver al Inicio</a>
                </div>
            </div>
        </div>
    </body>
</html>