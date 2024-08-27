package com.adopcion.controller;

import com.adopcion.domain.Publicacion;
import com.adopcion.service.FavoritoService;
import com.adopcion.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @Autowired
    private FavoritoService favoritoService;

    private static final String DEFAULT_UPLOAD_DIR = "src/main/resources/static/images/";

    @GetMapping("/listar")
    public String listarPublicaciones(Model model) {
        List<Publicacion> publicaciones = publicacionService.listarPublicaciones();
        model.addAttribute("publicaciones", publicaciones);
        model.addAttribute("favoritoService", favoritoService);
        return "publicaciones/listar";
    }

    @PostMapping("/crear")
    public String crearPublicacion(
            @ModelAttribute Publicacion publicacion,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            @RequestParam("videoFile") MultipartFile videoFile,
            @RequestParam(value = "uploadDir", required = false) String uploadDir) {

        try {
            String storageDir = (uploadDir == null || uploadDir.isEmpty()) ? DEFAULT_UPLOAD_DIR : uploadDir;

            if (!imagenFile.isEmpty()) {
                String fileName = imagenFile.getOriginalFilename();
                Path path = Paths.get(storageDir + fileName);
                Files.write(path, imagenFile.getBytes());
                publicacion.setImagenPath("/images/" + fileName);
            }
            if (!videoFile.isEmpty()) {
                String fileName = videoFile.getOriginalFilename();
                Path path = Paths.get(storageDir + fileName);
                Files.write(path, videoFile.getBytes());
                publicacion.setVideoPath("/images/" + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        publicacionService.crearPublicacion(publicacion);
        return "redirect:/publicaciones/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarPublicacion(@PathVariable Long id) {
        publicacionService.eliminarPublicacion(id);
        return "redirect:/publicaciones/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Publicacion publicacion = publicacionService.obtenerPublicacionPorId(id);
        model.addAttribute("publicacion", publicacion);
        return "publicaciones/editar";
    }

    @PostMapping("/actualizar")
    public String actualizarPublicacion(@ModelAttribute Publicacion publicacion,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            @RequestParam("videoFile") MultipartFile videoFile,
            @RequestParam(value = "uploadDir", required = false) String uploadDir) {

        Publicacion publicacionExistente = publicacionService.obtenerPublicacionPorId(publicacion.getId());

        if (publicacionExistente != null) {
            try {
                String storageDir = (uploadDir == null || uploadDir.isEmpty()) ? "src/main/resources/static/images/" : uploadDir;

                if (!imagenFile.isEmpty()) {
                    String fileName = imagenFile.getOriginalFilename();
                    Path path = Paths.get(storageDir + fileName);
                    Files.write(path, imagenFile.getBytes());
                    publicacionExistente.setImagenPath("/images/" + fileName);
                }

                if (!videoFile.isEmpty()) {
                    String fileName = videoFile.getOriginalFilename();
                    Path path = Paths.get(storageDir + fileName);
                    Files.write(path, videoFile.getBytes());
                    publicacionExistente.setVideoPath("/images/" + fileName);
                }

                publicacionExistente.setTitulo(publicacion.getTitulo());
                publicacionExistente.setDescripcion(publicacion.getDescripcion());
                publicacionExistente.setEdad(publicacion.getEdad());

                publicacionService.actualizarPublicacion(publicacionExistente);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "redirect:/publicaciones/listar";
    }
}
