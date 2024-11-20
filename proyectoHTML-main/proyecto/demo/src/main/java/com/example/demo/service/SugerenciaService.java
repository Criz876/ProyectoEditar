package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Sugerencia;

public interface SugerenciaService {

    List<Sugerencia> buscarTodasLasSugerencias();
    
    Sugerencia guardarSugerencia(Sugerencia sugerencia);
}