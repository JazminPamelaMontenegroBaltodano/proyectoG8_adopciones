package com.adopcion.dao;

import com.adopcion.domain.Favorito;
import com.adopcion.domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    List<Favorito> findByPublicacion(Publicacion publicacion);  
}
