package ec.sasf.prueba.Josue.Lapo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.sasf.prueba.Josue.Lapo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    @Procedure(procedureName = "sp_crear_usuario")
    void spCrearUsuario(
        @Param("p_nombres") String nombre,
        @Param("p_apellidos") String apellidos,
        @Param("p_email") String email,
        @Param("p_password") String password,
        @Param("p_tipo_usuario") String tipoUsuario
    );
}
