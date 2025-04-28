package ec.sasf.prueba.Josue.Lapo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.sasf.prueba.Josue.Lapo.model.Curso;
import ec.sasf.prueba.Josue.Lapo.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;


    // Crear curso con validación de límite (2 activos por creador)
    public void crearCurso(Curso curso) {
        try {
            Long creadorId = curso.getCreador().getId();
            String titulo = curso.getTitulo();
            String descripcion = curso.getDescripcion(); // ¡No puede ser null si el SP lo requiere!

            // Validación de 2 cursos activos
            if (cursoRepository.countByCreadorIdAndEstado(creadorId) >= 2) {
                throw new RuntimeException("Límite de cursos alcanzado");
            }
            
            cursoRepository.spCrearCurso(titulo, descripcion, creadorId); // 3 parámetros
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al crear el curso: " + e.getMessage());
        }
    }
    // Cambiar estado de curso (Ej: ACTIVO/INACTIVO)
    public void cambiarEstadoCurso(Long cursoId, String nuevoEstado) {
        Curso curso = cursoRepository.findById(cursoId)
            .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        curso.setEstado(nuevoEstado);
        cursoRepository.save(curso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll(); // Usa el método de JpaRepository
    }

    public Curso obtenerCursoPorId(Long cursoId) {
        return cursoRepository.findById(cursoId)
            .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }
}
