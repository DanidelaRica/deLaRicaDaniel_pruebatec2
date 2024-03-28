package com.mycompany.pruebatecnica2.logica;


import com.mycompany.pruebatecnica2.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.Date;

import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    /* CIUDADANOS */
    public void crearCiudadano(Ciudadano ciudadano) {
        controlPersis.crearCiudadano(ciudadano);
    }

    public void eliminarCiudadano(Long id) {
        controlPersis.eliminarCiudadano(id);
    }

    public List<Ciudadano> traerCiudadanos() {
        return controlPersis.traerCiudadanos();
    }

    public void editarCiudadano(Ciudadano ciudadano) {
        controlPersis.editarCiudadano(ciudadano);
    }

    public Ciudadano obtenerCiudadano(Long idCiudadano) {
        return controlPersis.obtenerCiudadano(idCiudadano);
    }

    /* TURNOS */
    public void crearTurno(Turno turno, Long idCiudadano) {
        // Obtener ciudadano a partir de su ID

        Ciudadano ciudadano = controlPersis.obtenerCiudadano(idCiudadano);

        // Asignar ciudadano al turno
        turno.setCiudadano(ciudadano);

        // Persistir el turno
        controlPersis.crearTurno(turno);
    }

    public void eliminarTurno(Long id) {
        controlPersis.eliminarTurno(id);
    }

    public List<Turno> traerTurnos() {
        return controlPersis.traerTurnos();
    }

    public void editarTurno(Turno turno) {
        controlPersis.editarTurno(turno);
    }
    
    public void editarEstadoTurno(Long id, String estado) {
        controlPersis.editarEstadoTurno(id, estado);
    }
    //Metodo para el filtro por fecha y estado
    public List<Turno> filtrarTurnosPorFechaYEstado(Date fecha, String estado) {
        
        return controlPersis.filtrarTurnosPorFechaYEstado(fecha, estado);
    }

}
