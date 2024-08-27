package com.adopcion.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
        name = "user_favoritos", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "publicacion_id")
    )
    private List<Publicacion> publicacionesFavoritas;

    // Constructor
    public User() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Publicacion> getPublicacionesFavoritas() {
        return publicacionesFavoritas;
    }

    public void setPublicacionesFavoritas(List<Publicacion> publicacionesFavoritas) {
        this.publicacionesFavoritas = publicacionesFavoritas;
    }
}
