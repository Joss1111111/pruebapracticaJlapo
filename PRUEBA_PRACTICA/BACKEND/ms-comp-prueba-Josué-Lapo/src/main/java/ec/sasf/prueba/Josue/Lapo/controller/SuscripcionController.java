package ec.sasf.prueba.Josue.Lapo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.prueba.Josue.Lapo.service.SuscripcionService;

@RestController
@RequestMapping("/api/suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionService suscripcionService;

    @PostMapping("/suscribir")
    public String suscribirCurso(Long usuarioId, Long cursoId) {
        suscripcionService.suscribirCurso(usuarioId, cursoId);
        return "Usuario suscrito al curso exitosamente.";
    }
}
