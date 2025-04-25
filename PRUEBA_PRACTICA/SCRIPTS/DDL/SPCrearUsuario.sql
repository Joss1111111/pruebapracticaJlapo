-- SP para crear usuario (solo ADMIN puede ejecutarlo)
CREATE OR REPLACE PROCEDURE sp_crear_usuario(
    p_nombres VARCHAR(100),
    p_apellidos VARCHAR(100),
    p_email VARCHAR(100),
    p_password VARCHAR(100),
    p_tipo_usuario VARCHAR(20)
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO usuarios (nombres, apellidos, email, password, tipo_usuario)
    VALUES (p_nombres, p_apellidos, p_email, p_password, p_tipo_usuario);
END;
$$;