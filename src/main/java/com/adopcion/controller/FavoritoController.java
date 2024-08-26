package com.adopcion.controller;

import com.adopcion.domain.Favorito;
import com.adopcion.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @GetMapping
    public String listarFavoritos(Model model) {
        List<Favorito> favoritos = favoritoService.listarTodos();
        model.addAttribute("favoritos", favoritos);
        return "favoritos/listar";
    }

    @GetMapping("/crear")
    public String crearFavoritoForm(Model model) {
        model.addAttribute("favorito", new Favorito());
        return "favoritos/crear";
    }

    @PostMapping("/guardar")
    public String guardarFavorito(@ModelAttribute Favorito favorito) {
        favoritoService.guardar(favorito);
        return "redirect:/favoritos";
    }

    @GetMapping("/editar/{id}")
    public String editarFavoritoForm(@PathVariable Long id, Model model) {
        Favorito favorito = favoritoService.obtenerPorId(id);
        model.addAttribute("favorito", favorito);
        return "favoritos/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarFavorito(@PathVariable Long id, @ModelAttribute Favorito favorito) {
        favorito.setId(id);
        favoritoService.guardar(favorito);
        return "redirect:/favoritos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFavorito(@PathVariable Long id) {
        favoritoService.eliminar(id);
        return "redirect:/favoritos";
    }
}
