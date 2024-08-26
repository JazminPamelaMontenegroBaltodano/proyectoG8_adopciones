package com.adopcion.service;

import com.adopcion.domain.Publicacion;
import java.util.List;

public interface PublicacionService {
    List<Publicacion> listarTodas();
    Publicacion guardar(Publicacion publicacion);
    Publicacion obtenerPorId(Long id);
    void eliminar(Long id);
}
