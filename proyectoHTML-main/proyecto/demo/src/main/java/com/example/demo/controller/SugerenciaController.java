package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Academico;
import com.example.demo.model.Sugerencia;
import com.example.demo.service.SugerenciaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sugerencias")
public class SugerenciaController {

    @Autowired
    private SugerenciaService sugerenciaService;

    @GetMapping("/registrar")
    public String mostrarFormularioSugerencia(HttpSession session, Model model) {
        // Verificar que solo académicos puedan registrar sugerencias
        Academico academico = (Academico) session.getAttribute("usuario");
        if (academico == null) {
            return "redirect:/login";
        }
        return "registrar-sugerencia"; // Vista para el formulario
    }

    @PostMapping("/registrar")
    @ResponseBody
    public ResponseEntity<?> registrarSugerencia(@RequestBody Map<String, String> datos, HttpSession session) {
        try {
            // Verificar que solo académicos puedan registrar sugerencias
            Academico academico = (Academico) session.getAttribute("usuario");
            if (academico == null) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acceso denegado");
            }

            // Crear nueva sugerencia
            Sugerencia sugerencia = new Sugerencia();
            sugerencia.setNombreSugerencia(datos.get("nombreSugerencia"));
            sugerencia.setDescripcionSugerencia(datos.get("descripcionSugerencia"));
            sugerencia.setEstadoSugerencia("Pendiente");
            sugerencia.setAcademico(academico);
            sugerencia.setFechaCreacionSugerencia(LocalDate.now());

            // Guardar sugerencia
            @SuppressWarnings("unused")
            Sugerencia nuevaSugerencia = sugerenciaService.registrarSugerencia(sugerencia);
            
            return ResponseEntity.ok("Sugerencia registrada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar sugerencia: " + e.getMessage());
        }
    }
}