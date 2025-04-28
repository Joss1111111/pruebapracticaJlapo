-- 1. Tabla de usuarios (cumple con campos de auditoría y tipos de usuario)
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    tipo_usuario VARCHAR(20) NOT NULL CHECK (tipo_usuario IN ('ADMIN', 'CREADOR', 'CONSUMIDOR')),
    fe_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fe_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BOOLEAN DEFAULT TRUE
);

-- 2. Tabla de cursos (con estados requeridos)
CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descripcion TEXT,
    estado VARCHAR(20) NOT NULL CHECK (estado IN ('EN_CONSTRUCCION', 'ACTIVO', 'INACTIVO')),
    creador_id INT NOT NULL,
    fe_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fe_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (creador_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- 3. Tabla de suscripciones (controla acceso de consumidores)
CREATE TABLE suscripciones (
    id SERIAL PRIMARY KEY,
    consumidor_id INT NOT NULL,
    curso_id INT NOT NULL,
    fe_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (consumidor_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (curso_id) REFERENCES cursos(id) ON DELETE CASCADE,
    UNIQUE (consumidor_id, curso_id) -- Evita suscripción duplicada
);