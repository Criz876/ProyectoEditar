package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "sugerencia")
public class Sugerencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sugerencia")
    private int idSugerencia;

    @Column(name = "estado")
    private String estadoSugerencia;

    @Column(name = "descripcion")
    private String descripcionSugerencia;

    @Column(name = "nombre_sugerencia")
    private String nombreSugerencia;

    @ManyToOne
    @JoinColumn(name = "academico_id", nullable = false)
    private Academico academico; // Relación con Academico

    @Column(name = "fecha_creacionSugerencia")
    private LocalDate fechaCreacionSugerencia;

    public int getIdSugerencia() {
        return idSugerencia;
    }

    public void setIdSugerencia(int idSugerencia) {
        this.idSugerencia = idSugerencia;
    }

    public String getEstadoSugerencia() {
        return estadoSugerencia;
    }

    public void setEstadoSugerencia(String estadoSugerencia) {
        this.estadoSugerencia = estadoSugerencia;
    }

    public String getDescripcionSugerencia() {
        return descripcionSugerencia;
    }

    public void setDescripcionSugerencia(String descripcionSugerencia) {
        this.descripcionSugerencia = descripcionSugerencia;
    }

    public String getNombreSugerencia() {
        return nombreSugerencia;
    }

    public void setNombreSugerencia(String nombreSugerencia) {
        this.nombreSugerencia = nombreSugerencia;
    }

    public Academico getAcademico() {
        return academico;
    }

    public void setAcademico(Academico academico) {
        this.academico = academico;
    }

    public LocalDate getFechaCreacionSugerencia() {
        return fechaCreacionSugerencia;
    }

    public void setFechaCreacionSugerencia(LocalDate fechaCreacionSugerencia) {
        this.fechaCreacionSugerencia = fechaCreacionSugerencia;
    }
}
