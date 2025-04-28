package ec.sasf.prueba.Josue.Lapo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ec.sasf.prueba.Josue.Lapo.model.Suscripcion;

@Repository
public interface  SuscripcionRepository  extends JpaRepository<Suscripcion, Long>{
    
    @Procedure(procedureName = "sp_suscribir_curso")
    void spSuscribirCurso(
        @Param("p_usuario_id") Long usuarioId,
        @Param("p_curso_id") Long cursoId
    );
}
