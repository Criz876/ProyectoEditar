package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Academico;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Sugerencia;
import com.example.demo.repository.SugerenciaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SugerenciaServiceImpl implements SugerenciaService {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    @Override
    public Sugerencia crearSugerencia(Sugerencia sugerencia) {
        sugerencia.setFechaCreacionSugerencia(LocalDate.now());
        sugerencia.setEstadoSugerencia("Pendiente");
        return sugerenciaRepository.save(sugerencia);
    }

    @Override
    public List<Sugerencia> obtenerSugerenciasPorEstudiante(Estudiante estudiante) {
        return sugerenciaRepository.findByEstudiante(estudiante);
    }

    @Override
    public List<Sugerencia> obtenerSugerenciasPorAcademico(Academico academico) {
        return sugerenciaRepository.findByAcademico(academico);
    }
}