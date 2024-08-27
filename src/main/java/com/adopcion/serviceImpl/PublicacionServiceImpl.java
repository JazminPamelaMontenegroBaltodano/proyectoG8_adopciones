package com.adopcion.serviceImpl;

import com.adopcion.domain.Publicacion;
import com.adopcion.service.PublicacionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    private List<Publicacion> publicaciones = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Publicacion> listarPublicaciones() {
        return new ArrayList<>(publicaciones);
    }

    @Override
    public void crearPublicacion(Publicacion publicacion) {
        publicacion.setId(nextId++);
        publicaciones.add(publicacion);
    }

    @Override
    public Publicacion obtenerPublicacionPorId(Long id) {
        return publicaciones.stream()
                .filter(pub -> pub.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarPublicacion(Publicacion publicacion) {
        publicaciones = publicaciones.stream()
                .map(pub -> pub.getId().equals(publicacion.getId()) ? publicacion : pub)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPublicacion(Long id) {
        publicaciones.removeIf(pub -> pub.getId().equals(id));
    }
// Lógica para actualizar imagen y video
    // Lógica para guardar nueva imagen y actualizar imagenPath
    // Lógica para guardar nuevo video y actualizar videoPath

    @Override
    public void actualizarPublicacion(Publicacion publicacion, MultipartFile imagenFile, MultipartFile videoFile) {
        publicaciones = publicaciones.stream()
                .map(pub -> {
                    if (pub.getId().equals(publicacion.getId())) {

                        if (!imagenFile.isEmpty()) {

                        }
                        if (!videoFile.isEmpty()) {

                        }
                        return publicacion;
                    }
                    return pub;
                })
                .collect(Collectors.toList());
    }
}
