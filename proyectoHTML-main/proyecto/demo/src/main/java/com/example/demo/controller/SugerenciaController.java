package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Academico;
import com.example.demo.model.Sugerencia;
import com.example.demo.service.SugerenciaService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/sugerencias")
public class SugerenciaController {

    @Autowired
    private SugerenciaService sugerenciaService;

    @PostMapping("/registrar")
    public ResponseEntity<Sugerencia> registrarSugerencia(@RequestBody Sugerencia sugerencia, HttpSession session) {
        // Verificar si el usuario es un académico
        Academico academico = (Academico) session.getAttribute("usuario");
        if (academico == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        sugerencia.setAcademico(academico);
        sugerencia.setFechaCreacionSugerencia(LocalDate.now());
        sugerencia.setEstadoSugerencia("Pendiente");
        Sugerencia nuevaSugerencia = sugerenciaService.registrarSugerencia(sugerencia);
        return new ResponseEntity<>(nuevaSugerencia, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Sugerencia>> obtenerSugerencias() {
        List<Sugerencia> sugerencias = sugerenciaService.buscarTodasLasSugerencias();
        return new ResponseEntity<>(sugerencias, HttpStatus.OK);
    }
}