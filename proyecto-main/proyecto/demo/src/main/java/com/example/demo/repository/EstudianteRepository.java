package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Estudiante;

public interface EstudianteRepository extends JpaRepository <Estudiante, Integer>{
    Estudiante findByCorreoEstudiante(String correoEstudiante);
    boolean existsByCorreoEstudiante(String correo);
}
