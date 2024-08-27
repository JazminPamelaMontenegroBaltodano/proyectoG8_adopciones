package com.adopcion.controller;

import com.adopcion.domain.Favorito;
import com.adopcion.domain.Publicacion;
import com.adopcion.service.FavoritoService;
import com.adopcion.service.PublicacionService;
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

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping("/listar")
    public String listarFavoritos(Model model) {
        List<Favorito> favoritos = favoritoService.listarFavoritos();
        model.addAttribute("favoritos", favoritos);
        return "favoritos/listar";
    }

    @PostMapping("/guardar")
    public String guardarFavorito(@RequestParam Long publicacionId) {
        Publicacion publicacion = publicacionService.obtenerPublicacionPorId(publicacionId);

        if (publicacion != null) {
            Favorito favoritoExistente = favoritoService.obtenerPorPublicacion(publicacion);
            if (favoritoExistente == null) {
                Favorito favorito = new Favorito();
                favorito.setPublicacion(publicacion);
                favoritoService.guardarFavorito(favorito);
            }
        }

        return "redirect:/publicaciones/listar";
    }

    @PostMapping("/eliminar")
    public String eliminarFavorito(@RequestParam Long favoritoId) {
        favoritoService.eliminarFavorito(favoritoId);
        return "redirect:/favoritos/listar";
    }
}
