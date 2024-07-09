package com.adopcion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageController {

    @GetMapping("/registro")
    public String showRegistroPage() {
        return "registro.html";
    }

    @GetMapping("/inicio_sesion")
    public String showInicioSesionPage() {
        return "inicio_sesion.html";
    }
}
