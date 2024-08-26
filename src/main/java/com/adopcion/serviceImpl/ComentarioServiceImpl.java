package com.adopcion.serviceImpl;

import com.adopcion.dao.ComentarioRepository;
import com.adopcion.domain.Comentario;
import com.adopcion.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> listarTodos() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario guardar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public Comentario obtenerPorId(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        comentarioRepository.deleteById(id);
    }
}
