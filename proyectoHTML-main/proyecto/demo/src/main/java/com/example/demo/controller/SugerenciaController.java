package com.example.demo.controller;

import java.util.List;
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
import com.example.demo.model.Estudiante;
import com.example.demo.model.Sugerencia;
import com.example.demo.service.AcademicoService;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.SugerenciaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sugerencia")
public class SugerenciaController {
    @Autowired
    private SugerenciaService sugerenciaService;
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private AcademicoService academicoService;

    @GetMapping("/crear")
    public String mostrarFormularioSugerencia(HttpSession session, Model model) {
        String tipoUsuario = (String) session.getAttribute("tipoUsuario");
        String correoUsuario = (String) session.getAttribute("correoUsuario");

        if (tipoUsuario == null || (!tipoUsuario.equals("estudiante") && !tipoUsuario.equals("academico"))) {
            return "redirect:/login";
        }

        model.addAttribute("sugerencia", new Sugerencia());
        return "crear-sugerencia";
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<?> crearSugerencia(
        @RequestBody Map<String, String> datos, 
        HttpSession session
    ) {
        String tipoUsuario = (String) session.getAttribute("tipoUsuario");
        String correoUsuario = (String) session.getAttribute("correoUsuario");

        if (tipoUsuario == null || (!tipoUsuario.equals("estudiante") && !tipoUsuario.equals("academico"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
        }

        try {
            Sugerencia sugerencia = new Sugerencia();
            sugerencia.setNombreSugerencia(datos.get("nombreSugerencia"));
            sugerencia.setDescripcionSugerencia(datos.get("descripcionSugerencia"));

            if (tipoUsuario.equals("estudiante")) {
                Estudiante estudiante = estudianteService.buscarPorCorreo(correoUsuario);
                sugerencia.setEstudiante(estudiante);
                
                Academico academico = academicoService.buscarAcademicoPorId(
                    Integer.parseInt(datos.get("academicoId"))
                );
                sugerencia.setAcademico(academico);
            } else {
                Academico academico = academicoService.buscarPorCorreo(correoUsuario);
                sugerencia.setAcademico(academico);
                
                Estudiante estudiante = estudianteService.buscarEstudiantePorId(
                    Integer.parseInt(datos.get("estudianteId"))
                );
                sugerencia.setEstudiante(estudiante);
            }

            sugerenciaService.crearSugerencia(sugerencia);
            return ResponseEntity.ok("Sugerencia creada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear sugerencia: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public String listarSugerencias(HttpSession session, Model model) {
        String tipoUsuario = (String) session.getAttribute("tipoUsuario");
        String correoUsuario = (String) session.getAttribute("correoUsuario");

        if (tipoUsuario == null || (!tipoUsuario.equals("estudiante") && !tipoUsuario.equals("academico"))) {
            return "redirect:/login";
        }

        List<Sugerencia> sugerencias;
        if (tipoUsuario.equals("estudiante")) {
            Estudiante estudiante = estudianteService.buscarPorCorreo(correoUsuario);
            sugerencias = sugerenciaService.obtenerSugerenciasPorEstudiante(estudiante);
        } else {
            Academico academico = academicoService.buscarPorCorreo(correoUsuario);
            sugerencias = sugerenciaService.obtenerSugerenciasPorAcademico(academico);
        }

        model.addAttribute("sugerencias", sugerencias);
        return "listar-sugerencias";
    }
}