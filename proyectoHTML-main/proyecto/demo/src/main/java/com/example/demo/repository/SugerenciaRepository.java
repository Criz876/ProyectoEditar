package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Sugerencia;

public interface SugerenciaRepository extends JpaRepository<Sugerencia, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}