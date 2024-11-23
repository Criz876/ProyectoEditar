package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Academico;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Sugerencia;

public interface SugerenciaService {
    public Sugerencia crearSugerencia(Sugerencia sugerencia);
    public List<Sugerencia> obtenerSugerenciasPorEstudiante(Estudiante estudiante);
    public List<Sugerencia> obtenerSugerenciasPorAcademico(Academico academico);
}