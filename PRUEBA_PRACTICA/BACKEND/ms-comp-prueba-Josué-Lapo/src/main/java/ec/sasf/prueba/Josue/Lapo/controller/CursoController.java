package ec.sasf.prueba.Josue.Lapo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.prueba.Josue.Lapo.dto.CambioEstadoRequest;
import ec.sasf.prueba.Josue.Lapo.model.Curso;
import ec.sasf.prueba.Josue.Lapo.service.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        cursoService.crearCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        return new ResponseEntity<>(cursoService.listarCursos(), HttpStatus.OK);
    }

    @GetMapping("/{cursoId}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable Long cursoId) {
        //Curso curso = cursoService.obtenerCursoPorId(cursoId);
        return cursoService.obtenerCursoPorId(cursoId)
                .map(curso -> ResponseEntity.ok(curso))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{cursoId}/estado")
    public ResponseEntity<?> cambiarEstadoCurso(
            @PathVariable Long cursoId,
            @RequestBody CambioEstadoRequest request) {
        cursoService.cambiarEstadoCurso(cursoId, request.getNuevoEstado());
        return ResponseEntity.ok().build();
    }

}
