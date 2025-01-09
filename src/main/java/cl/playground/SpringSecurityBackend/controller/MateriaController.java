package cl.playground.SpringSecurityBackend.controller;

import cl.playground.SpringSecurityBackend.dto.MateriaCreateDTO;
import cl.playground.SpringSecurityBackend.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @PostMapping
    @Transactional
    public ResponseEntity<MateriaCreateDTO> crearMateria(@RequestBody MateriaCreateDTO materia) {
        materiaService.saveMateria(materia);
        return ResponseEntity.ok().body(materia);
    }
    // ALOHA
}
