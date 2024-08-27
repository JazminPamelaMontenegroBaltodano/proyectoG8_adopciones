package com.adopcion.service;

import com.adopcion.domain.Publicacion;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface PublicacionService {
    List<Publicacion> listarPublicaciones();
    void crearPublicacion(Publicacion publicacion);
    Publicacion obtenerPublicacionPorId(Long id);
    void actualizarPublicacion(Publicacion publicacion);
    void eliminarPublicacion(Long id);
     void actualizarPublicacion(Publicacion publicacion, MultipartFile imagenFile, MultipartFile videoFile);
}
