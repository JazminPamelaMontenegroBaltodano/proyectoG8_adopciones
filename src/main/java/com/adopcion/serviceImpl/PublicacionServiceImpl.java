package com.adopcion.serviceImpl;

import com.adopcion.dao.PublicacionRepository;
import com.adopcion.domain.Publicacion;
import com.adopcion.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public List<Publicacion> listarTodas() {
        return publicacionRepository.findAll();
    }

    @Override
    public Publicacion guardar(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public Publicacion obtenerPorId(Long id) {
        return publicacionRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        publicacionRepository.deleteById(id);
    }
}
