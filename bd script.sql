-- Crear la base de datos
CREATE DATABASE animali_db;

-- Usar la base de datos
USE animali_db;

-- Crear un usuario de base de datos con todos los privilegios
CREATE USER 'animali_user'@'localhost' IDENTIFIED BY 'Animali123';
GRANT ALL PRIVILEGES ON animali_db.* TO 'animali_user'@'localhost';
FLUSH PRIVILEGES;

-- Tabla de usuarios
CREATE TABLE Usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(255)
);

-- Tabla de mascotas
CREATE TABLE Mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    raza VARCHAR(100),
    edad INT,
    condicionSalud VARCHAR(255)
);

-- Tabla de publicaciones
CREATE TABLE Publicacion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_publicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id BIGINT,
    mascota_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (mascota_id) REFERENCES Mascota(id)
);

-- Tabla de favoritos
CREATE TABLE Favorito (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    publicacion_id BIGINT,
    fecha_agregado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (publicacion_id) REFERENCES Publicacion(id)
);

-- Tabla de comentarios
CREATE TABLE Comentario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contenido TEXT NOT NULL,
    fecha_comentario TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id BIGINT,
    publicacion_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREemailPRIMARYIGN KEY (publicacion_id) REFERENCES Publicacion(id)
);

