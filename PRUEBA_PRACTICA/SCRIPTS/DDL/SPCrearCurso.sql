-- SP para crear curso (valida límite de 2 cursos activos por creador)
CREATE OR REPLACE PROCEDURE sp_crear_curso(
    p_titulo VARCHAR(200),
    p_descripcion TEXT,
    p_creador_id INT
)
LANGUAGE plpgsql
AS $$
DECLARE
    v_cursos_activos INT;
BEGIN
    -- Validar que el creador no tenga más de 2 cursos activos
    SELECT COUNT(*) INTO v_cursos_activos 
    FROM cursos 
    WHERE creador_id = p_creador_id AND estado = 'ACTIVO';

    IF v_cursos_activos >= 2 THEN
        RAISE EXCEPTION 'El creador ya tiene 2 cursos activos (límite alcanzado)';
    ELSE
        INSERT INTO cursos (titulo, descripcion, estado, creador_id)
        VALUES (p_titulo, p_descripcion, 'EN_CONSTRUCCION', p_creador_id);
    END IF;
END;
$$;