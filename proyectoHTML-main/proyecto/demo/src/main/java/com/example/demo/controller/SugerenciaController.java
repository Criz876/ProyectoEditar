package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Sugerencia;
import com.example.demo.service.SugerenciaService;

@Controller
public class SugerenciaController {

    @Autowired
    private SugerenciaService sugerenciaService;

    @GetMapping("/crear-sugerencia")
    public String mostrarFormularioSugerencia() {
        return "crear-sugerencia";
    }

    @PostMapping("/crear-sugerencia")
    @ResponseBody
    public ResponseEntity<?> crearSugerencia(@RequestBody Map<String, String> datos) {
        try {
            Sugerencia sugerencia = new Sugerencia();
            sugerencia.setNombreSugerencia(datos.get("nombreSugerencia"));
            sugerencia.setDescripcionSugerencia(datos.get("descripcionSugerencia"));
            sugerencia.setEstadoSugerencia("Pendiente"); // Estado inicial
            
            // Aquí puedes agregar lógica para obtener el académico o estudiante actual
            // por ejemplo, desde la sesión
            // sugerencia.setAcademico(academicoActual);
            // o sugerencia.setEstudiante(estudianteActual);

            sugerenciaService.crearSugerencia(sugerencia);
            return ResponseEntity.ok(Map.of("message", "Sugerencia creada exitosamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Error al crear la sugerencia: " + e.getMessage()));
        }
    }
}