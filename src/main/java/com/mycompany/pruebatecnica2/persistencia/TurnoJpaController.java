package com.mycompany.pruebatecnica2.persistencia;

import com.mycompany.pruebatecnica2.logica.Turno;

import com.mycompany.pruebatecnica2.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TurnoJpaController implements Serializable {

    public TurnoJpaController() {
        emf = Persistence.createEntityManagerFactory("pruebaPU");
    }

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            turno = em.merge(turno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = turno.getId();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editarEstadoTurno(Long id, String estado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // Buscar el turno por su ID
            Turno turno = em.find(Turno.class, id);
            if (turno == null) {
                throw new NonexistentEntityException("El turno con ID " + id + " no existe.");
            }

            // Actualizar el estado del turno
            turno.setEstado(estado);

            // Guardar los cambios en la base de datos
            em.merge(turno);

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Turno findTurno(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Turno> filtrarTurnosPorFechaYEstado(Date fecha, String estado) {
        // Convertir Date a LocalDate
        LocalDate fechaLocal = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Obtener todos los turnos
        List<Turno> turnos = findTurnoEntities();

        // Filtrar los turnos por fecha y estado
        return turnos.stream()
                .filter(turno -> {
                    // Convertir la fecha del turno a LocalDate
                    LocalDate fechaTurno = turno.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    // Comparar solo las fechas, sin tener en cuenta la hora exacta
                    return fechaTurno.equals(fechaLocal);
                })
                .filter(turno -> turno.getEstado().equalsIgnoreCase(estado)) // Filtrar por estado
                .collect(Collectors.toList()); // Recolectar los resultados en una lista
    }

}
