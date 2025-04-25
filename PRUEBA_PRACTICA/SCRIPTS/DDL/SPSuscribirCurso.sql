-- SP para suscribir consumidor (valida 1 curso por creador)
CREATE OR REPLACE PROCEDURE sp_suscribir_curso(
    p_consumidor_id INT,
    p_curso_id INT
)
LANGUAGE plpgsql
AS $$
DECLARE
    v_creador_id INT;
    v_suscripcion_existente INT;
BEGIN
    -- Obtener el creador del curso
    SELECT creador_id INTO v_creador_id FROM cursos WHERE id = p_curso_id;

    -- Validar que el consumidor no esté ya suscrito a otro curso del mismo creador
    SELECT COUNT(*) INTO v_suscripcion_existente
    FROM suscripciones s
    JOIN cursos c ON s.curso_id = c.id
    WHERE s.consumidor_id = p_consumidor_id AND c.creador_id = v_creador_id;

    IF v_suscripcion_existente > 0 THEN
        RAISE EXCEPTION 'El consumidor ya está suscrito a un curso de este creador';
    ELSE
        INSERT INTO suscripciones (consumidor_id, curso_id)
        VALUES (p_consumidor_id, p_curso_id);
    END IF;
END;
$$;