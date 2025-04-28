package ec.sasf.prueba.Josue.Lapo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.sasf.prueba.Josue.Lapo.model.Usuario;
import ec.sasf.prueba.Josue.Lapo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Crear usuario (sin validación de roles por ahora)
    public void crearUsuario(Usuario usuario) {
        try {
            String nombre = usuario.getNombres();
            String apellidos = usuario.getApellidos();
            String email = usuario.getEmail();
            String password = usuario.getPassword(); // ¡No puede ser null si el SP lo requiere!
            String tipoUsuario = usuario.getTipoUsuario(); // ¡No puede ser null si el SP lo requiere!
            // 3 parámetros
            usuarioRepository.spCrearUsuario(nombre, apellidos, email, password, tipoUsuario); // 5 parámetros
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al crear el curso: " + e.getMessage());
        }
    }

    // Obtener usuario por email (para simular login básico)
    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Validar si un usuario es ADMIN (para endpoints críticos)
    public boolean esAdmin(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return "ADMIN".equals(usuario.getTipoUsuario());
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll(); // Usa el método de JpaRepository
    }

    public Usuario obtenerUsuarioPorId(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    

    // Cambiar estado de usuario (Ej: ACTIVO/INACTIVO)
    public void cambiarEstadoUsuario(Long usuarioId, Boolean nuevoEstado) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setEstado(nuevoEstado);
        usuarioRepository.save(usuario);
    }
}
