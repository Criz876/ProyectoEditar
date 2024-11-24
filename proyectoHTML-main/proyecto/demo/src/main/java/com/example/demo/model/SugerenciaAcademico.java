package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "sugerencia_academico")
public class SugerenciaAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sugerencia")
    private int idSugerencia;

    @Column(name = "estado")
    private String estadoSugerencia = "Pendiente"; // Estado por defecto

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    @Column(name = "descripcion")
    private String descripcionSugerencia;

    @NotBlank(message = "El nombre de la sugerencia no puede estar vacío")
    @Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
    @Column(name = "nombre_sugerencia")
    private String nombreSugerencia;

    // Cambiar el nombre de la columna para que coincida con la base de datos
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacionSugerencia = LocalDateTime.now(); // Fecha actual por defecto

    @ManyToOne
    @JoinColumn(name = "id_academico")
    private Academico academico;

    // Getters y Setters
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

    public Academico getAcademico() {
        return academico;
    }

    public void setAcademico(Academico academico) {
        this.academico = academico;
    }
}