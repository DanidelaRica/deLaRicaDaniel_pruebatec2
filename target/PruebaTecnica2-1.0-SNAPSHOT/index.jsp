<%@page import="com.mycompany.pruebatecnica2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bienvenido al sistema de gestión de turnos</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="text-center mb-4">Bienvenido al sistema de gestión de turnos</h1>
            <div class="row">
                <div class="col-md-3">
                    <a href="nuevoCiudadano.jsp" class="btn btn-secondary btn-block">Crear Nuevo Ciudadano</a>
                </div>
                <div class="col-md-3">
                    <a href="nuevoTurno.jsp" class="btn btn-primary btn-block">Agregar Nuevo Turno</a>
                </div>
                <div class="col-md-3">
                    <form action="TurnosSV" method="GET">    
                        <button type="submit" class="btn btn-success btn-block">Listar Turnos</button>
                    </form>
                </div>
                <div class="col-md-3">
                    <a href="filtrarTurnos.jsp" class="btn btn-info btn-block">Filtrar Turnos</a>
                </div>                
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>