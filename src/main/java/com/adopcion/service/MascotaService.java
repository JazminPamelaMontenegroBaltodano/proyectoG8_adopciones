package com.adopcion.service;

import com.adopcion.domain.Mascota;
import java.util.List;

public interface MascotaService {
    List<Mascota> listarTodas();
    Mascota guardar(Mascota mascota);
    Mascota obtenerPorId(Long id);
    void eliminar(Long id);
}
