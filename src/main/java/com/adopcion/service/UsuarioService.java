package com.adopcion.service;

import com.adopcion.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listarTodos();
    Usuario guardar(Usuario usuario);
    Usuario obtenerPorId(Long id);
    void eliminar(Long id);
}
