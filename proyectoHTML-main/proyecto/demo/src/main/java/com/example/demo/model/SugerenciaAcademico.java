package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "sugerencia_academico")
public class SugerenciaAcademico {

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

    @Column(name = "fecha_creacionSugerencia")
    private LocalDateTime fechaCreacionSugerencia;

    @Column(name = "id_academico")
    private int idAcademicoSug;

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

    public LocalDateTime getFechaCreacionSugerencia() {
        return fechaCreacionSugerencia;
    }

    public void setFechaCreacionSugerencia(LocalDateTime fechaCreacionSugerencia) {
        this.fechaCreacionSugerencia = fechaCreacionSugerencia;
    }

    public int getIdAcademicoSug() {
        return idAcademicoSug;
    }

    public void setIdAcademicoSug(int idAcademicoSug) {
        this.idAcademicoSug = idAcademicoSug;
    }
    
}
