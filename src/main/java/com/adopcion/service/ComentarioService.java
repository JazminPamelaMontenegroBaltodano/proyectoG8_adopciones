package com.adopcion.service;

import com.adopcion.domain.Comentario;
import java.util.List;

public interface ComentarioService {
    List<Comentario> listarTodos();
    Comentario guardar(Comentario comentario);
    Comentario obtenerPorId(Long id);
    void eliminar(Long id);
}
