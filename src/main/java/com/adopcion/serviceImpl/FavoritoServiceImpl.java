package com.adopcion.serviceImpl;

import com.adopcion.dao.FavoritoRepository;
import com.adopcion.domain.Favorito;
import com.adopcion.domain.Publicacion;
import com.adopcion.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoServiceImpl implements FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    @Override
    public List<Favorito> listarFavoritos() {
        return favoritoRepository.findAll();
    }

    @Override
    public Favorito guardarFavorito(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    @Override
    public void eliminarFavorito(Long id) {
        favoritoRepository.deleteById(id);
    }

    @Override
    public Favorito obtenerPorPublicacion(Publicacion publicacion) {
        return (Favorito) favoritoRepository.findByPublicacion(publicacion);
    }
}
