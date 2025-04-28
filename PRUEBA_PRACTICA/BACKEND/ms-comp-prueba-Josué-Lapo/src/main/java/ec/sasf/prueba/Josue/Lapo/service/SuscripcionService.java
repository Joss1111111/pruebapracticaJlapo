package ec.sasf.prueba.Josue.Lapo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.sasf.prueba.Josue.Lapo.repository.SuscripcionRepository;

@Service
public class SuscripcionService {
    @Autowired
    private SuscripcionRepository suscripcionRepository;

    public void suscribirCurso(Long usuarioId, Long cursoId) {
        try {
            // Llamar al procedimiento almacenado para suscribir al usuario al curso
            suscripcionRepository.spSuscribirCurso(usuarioId, cursoId);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al suscribir al curso: " + e.getMessage());
        }
    }
}
