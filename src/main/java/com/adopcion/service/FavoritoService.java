package com.adopcion.service;

import com.adopcion.domain.Favorito;
import java.util.List;

public interface FavoritoService {
    List<Favorito> listarTodos();
    Favorito guardar(Favorito favorito);
    Favorito obtenerPorId(Long id);
    void eliminar(Long id);
}

