package ec.sasf.prueba.Josue.Lapo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.sasf.prueba.Josue.Lapo.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Procedure(procedureName = "sp_crear_curso")
    void spCrearCurso(
        @Param("p_titulo") String titulo,
        @Param("p_descripcion") String descripcion, 
        @Param("p_creador_id") Long creadorId
    );

    // Validación de cursos activos
    @Query("SELECT COUNT(c) FROM Curso c WHERE c.creador.id = :creadorId AND c.estado = 'ACTIVO'")
    long countByCreadorIdAndEstado(@Param("creadorId") Long creadorId);

}
