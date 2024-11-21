package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Academico;
import com.example.demo.model.Sugerencia;
import com.example.demo.service.SugerenciaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sugerencias")
public class SugerenciaController {

    @Autowired
    private SugerenciaService sugerenciaService;

    @GetMapping("/nuevo")
    public String mostrarFormularioSugerencia(Model model) {
        model.addAttribute("sugerencia", new Sugerencia());
        return "formulario-sugerencia"; // Nombre de la vista para el formulario
    }

    @PostMapping("/registrar")
    public String registrarSugerencia(Sugerencia sugerencia, HttpSession session) {
        Academico academico = (Academico) session.getAttribute("usuario");
        if (academico == null) {
            return "redirect:/login"; // Redirige al login si no hay sesión activa
        }

        sugerencia.setAcademico(academico);
        sugerencia.setFechaCreacionSugerencia(LocalDate.now());
        sugerencia.setEstadoSugerencia("Pendiente");
        sugerenciaService.registrarSugerencia(sugerencia);
        
        return "redirect:/sugerencias"; // Redirige a la lista de sugerencias o a otra página
    }

    @GetMapping
    public String obtenerSugerencias(Model model) {
        model.addAttribute("sugerencias", sugerenciaService.buscarTodasLasSugerencias());
        return "lista-sugerencias"; // Nombre de la vista que mostrará la lista de sugerencias
    }
}