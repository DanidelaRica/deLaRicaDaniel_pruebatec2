package com.mycompany.pruebatecnica2.persistencia;

import com.mycompany.pruebatecnica2.logica.Ciudadano;
import com.mycompany.pruebatecnica2.logica.Turno;

import com.mycompany.pruebatecnica2.persistencia.exceptions.NonexistentEntityException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ControladoraPersistencia {

    CiudadanoJpaController ciudadanoJPA = new CiudadanoJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();

    /*PARA CIUDADANO*/
    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJPA.create(ciudadano);
    }

    public void eliminarCiudadano(Long id) {
        try {
            ciudadanoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ciudadano> traerCiudadanos() {
        return ciudadanoJPA.findCiudadanoEntities();
    }

    public void editarCiudadano(Ciudadano ciudadano) {
        try {
            ciudadanoJPA.edit(ciudadano);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Ciudadano obtenerCiudadano(Long id) {
        return ciudadanoJPA.findCiudadano(id);
    }

    /*PARA TURNO*/
    public void crearTurno(Turno turno) {
        turnoJPA.create(turno);
    }

    public void eliminarTurno(Long id) {
        try {
            turnoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Turno> traerTurnos() {
        return turnoJPA.findTurnoEntities();
    }

    public void editarTurno(Turno turno) {
        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarEstadoTurno(Long id, String estado) {
        try {
            turnoJPA.editarEstadoTurno(id, estado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para filtrar turnos por fecha y estado
    public List<Turno> filtrarTurnosPorFechaYEstado(Date fecha, String estado) {
        // Llamar al método correspondiente en turnoJPA para realizar la consulta
        return turnoJPA.filtrarTurnosPorFechaYEstado(fecha, estado);
    }
 

}
