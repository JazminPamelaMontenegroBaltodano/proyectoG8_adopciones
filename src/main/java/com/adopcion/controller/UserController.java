package com.adopcion.controller;

import com.adopcion.domain.User;
import com.adopcion.service.UserService;
import jakarta.servlet.http.HttpSession;
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
        try {
            userService.registerUser(user);
            return "registro-exitoso";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User loginUser, HttpSession session) {
        Optional<User> user = userService.loginUser(loginUser.getEmail(), loginUser.getPassword());
        if (user.isPresent()) {
            session.setAttribute("loggedInUser", user.get());
            return "redirect:/";
        }
        return "error-inicio-sesion";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
