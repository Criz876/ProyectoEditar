package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Sugerencia;

public interface SugerenciaService {
    public List<Sugerencia> buscarTodasLasSugerencias();
    public Sugerencia registrarSugerencia(Sugerencia sugerencia);
}