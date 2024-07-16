-- Crear la base de datos
CREATE DATABASE animali_db;

-- Usar la base de datos
USE animali_db;

-- Crear la tabla usuario
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    nombre_usuario VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Crear un usuario de base de datos con todos los privilegios
CREATE USER 'animali_user'@'localhost' IDENTIFIED BY 'Animali123';
GRANT ALL PRIVILEGES ON animali_db.* TO 'animali_user'@'localhost';
FLUSH PRIVILEGES;