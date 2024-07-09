package com.adopcion.controller;

import com.adopcion.domain.User;
import com.adopcion.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "Registro exitoso!";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User loginUser) {
        Optional<User> user = userService.loginUser(loginUser.getEmail(), loginUser.getPassword());
        if (user.isPresent()) {
            return "Inicio de sesión exitoso!";
        }
        return "Error en inicio de sesión!";
    }
}

