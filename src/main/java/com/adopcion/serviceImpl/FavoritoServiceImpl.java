package com.adopcion.serviceImpl;

import com.adopcion.dao.FavoritoRepository;
import com.adopcion.domain.Favorito;
import com.adopcion.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoServiceImpl implements FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    @Override
    public List<Favorito> listarTodos() {
        return favoritoRepository.findAll();
    }

    @Override
    public Favorito guardar(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    @Override
    public Favorito obtenerPorId(Long id) {
        return favoritoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        favoritoRepository.deleteById(id);
    }
}
