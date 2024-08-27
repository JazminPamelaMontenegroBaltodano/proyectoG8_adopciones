package com.adopcion;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class Configuracion {

    private static final String UPLOADED_FOLDER = "C:/ruta/de/almacenamiento/";

    @PostConstruct
    public void init() {
        try {
            // Para Crear la carpeta de almacenamiento si no existe
            //NOOO BORRAR
            Files.createDirectories(Paths.get(UPLOADED_FOLDER));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
