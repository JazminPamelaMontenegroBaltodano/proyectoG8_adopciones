package com.adopcion.controller;

import com.adopcion.domain.Comentario;
import com.adopcion.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public String listarComentarios(Model model) {
        List<Comentario> comentarios = comentarioService.listarTodos();
        model.addAttribute("comentarios", comentarios);
        return "comentarios/listar";
    }

    @GetMapping("/crear")
    public String crearComentarioForm(Model model) {
        model.addAttribute("comentario", new Comentario());
        return "comentarios/crear";
    }

    @PostMapping("/guardar")
    public String guardarComentario(@ModelAttribute Comentario comentario) {
        comentarioService.guardar(comentario);
        return "redirect:/comentarios";
    }

    @GetMapping("/editar/{id}")
    public String editarComentarioForm(@PathVariable Long id, Model model) {
        Comentario comentario = comentarioService.obtenerPorId(id);
        model.addAttribute("comentario", comentario);
        return "comentarios/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarComentario(@PathVariable Long id, @ModelAttribute Comentario comentario) {
        comentario.setId(id);
        comentarioService.guardar(comentario);
        return "redirect:/comentarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminar(id);
        return "redirect:/comentarios";
    }
}
