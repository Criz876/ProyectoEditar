package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Academico;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Sugerencia;

public interface SugerenciaRepository extends JpaRepository<Sugerencia, Integer> {
    List<Sugerencia> findByEstudiante(Estudiante estudiante);
    List<Sugerencia> findByAcademico(Academico academico);
}