package com.adopcion.controller;

import com.adopcion.domain.Publicacion;
import com.adopcion.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping
    public String listarPublicaciones(Model model) {
        List<Publicacion> publicaciones = publicacionService.listarTodas();
        model.addAttribute("publicaciones", publicaciones);
        return "publicaciones/listar"; // Ruta a listar.html
    }

    @GetMapping("/crear")
    public String crearPublicacionForm(Model model) {
        model.addAttribute("publicacion", new Publicacion());
        return "publicaciones/crear"; // Ruta a crear.html
    }

    @PostMapping("/guardar")
    public String guardarPublicacion(@ModelAttribute Publicacion publicacion) {
        publicacionService.guardar(publicacion);
        return "redirect:/publicaciones"; // Redirige a la lista de publicaciones
    }

    @GetMapping("/editar/{id}")
    public String editarPublicacionForm(@PathVariable Long id, Model model) {
        Publicacion publicacion = publicacionService.obtenerPorId(id);
        model.addAttribute("publicacion", publicacion);
        return "publicaciones/editar"; // Ruta a editar.html
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPublicacion(@PathVariable Long id, @ModelAttribute Publicacion publicacion) {
        publicacion.setId(id);
        publicacionService.guardar(publicacion);
        return "redirect:/publicaciones"; // Redirige a la lista de publicaciones
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPublicacion(@PathVariable Long id) {
        publicacionService.eliminar(id);
        return "redirect:/publicaciones"; // Redirige a la lista de publicaciones
    }
}
