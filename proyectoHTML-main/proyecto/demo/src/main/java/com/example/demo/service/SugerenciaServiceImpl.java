package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sugerencia;
import com.example.demo.repository.SugerenciaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SugerenciaServiceImpl implements SugerenciaService {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    @Override
    public List<Sugerencia> buscarTodasLasSugerencias() {
        return sugerenciaRepository.findAll();
    }

    @Override
    public Sugerencia guardarSugerencia(Sugerencia sugerencia) {
        return sugerenciaRepository.save(sugerencia);
    }
}