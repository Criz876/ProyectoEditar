package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sugerencia;
import com.example.demo.service.SugerenciaService;

@RestController
@RequestMapping("/sugerencias")
public class SugerenciaController {

    @Autowired
    private SugerenciaService sugerenciaService;

    @GetMapping("")
    public List<Sugerencia> listarSugerencias() {
        return sugerenciaService.buscarTodasLasSugerencias();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Sugerencia> guardarSugerencia(@RequestBody Sugerencia sugerencia) {
        Sugerencia nuevaSugerencia = sugerenciaService.guardarSugerencia(sugerencia);
        return new ResponseEntity<>(nuevaSugerencia, HttpStatus.CREATED);
    }
}