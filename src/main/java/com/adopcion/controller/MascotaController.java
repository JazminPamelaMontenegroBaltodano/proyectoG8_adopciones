package com.adopcion.controller;

import com.adopcion.domain.Mascota;
import com.adopcion.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public String listarMascotas(Model model) {
        List<Mascota> mascotas = mascotaService.listarTodas();
        model.addAttribute("mascotas", mascotas);
        return "mascotas/listar";
    }

    @GetMapping("/crear")
    public String crearMascotaForm(Model model) {
        model.addAttribute("mascota", new Mascota());
        return "mascotas/crear";
    }

    @PostMapping("/guardar")
    public String guardarMascota(@ModelAttribute Mascota mascota) {
        mascotaService.guardar(mascota);
        return "redirect:/mascotas";
    }

    @GetMapping("/editar/{id}")
    public String editarMascotaForm(@PathVariable Long id, Model model) {
        Mascota mascota = mascotaService.obtenerPorId(id);
        model.addAttribute("mascota", mascota);
        return "mascotas/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarMascota(@PathVariable Long id, @ModelAttribute Mascota mascota) {
        mascota.setId(id);
        mascotaService.guardar(mascota);
        return "redirect:/mascotas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return "redirect:/mascotas";
    }
}
