package com.adopcion.service;

import com.adopcion.domain.Favorito;
import com.adopcion.domain.Publicacion;

import java.util.List;

public interface FavoritoService {
    List<Favorito> listarFavoritos();
    Favorito guardarFavorito(Favorito favorito);
    void eliminarFavorito(Long id);
    Favorito obtenerPorPublicacion(Publicacion publicacion);
}

// NO implementado