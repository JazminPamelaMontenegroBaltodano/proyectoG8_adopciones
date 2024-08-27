package com.adopcion.service;

import com.adopcion.domain.User;
import java.util.Optional;

public interface UserService {
    void registerUser(User user);
    Optional<User> loginUser(String email, String password);
    User obtenerUsuarioPorId(Long id);

}