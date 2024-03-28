package com.mycompany.pruebatecnica2.logica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String descripcion;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "ciudadano_id")
    private Ciudadano ciudadano;

    public Turno() {
    }

    public Turno(Date fecha, String descripcion, String estado, Ciudadano ciudadano) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estado = "EN_ESPERA";
        this.ciudadano = ciudadano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

   /*public String getFechaFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        return sdf.format(fecha);
    }*/
    public LocalDate getFechaLocalDate() {
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
