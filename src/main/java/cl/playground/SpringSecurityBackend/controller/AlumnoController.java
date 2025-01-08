package cl.playground.SpringSecurityBackend.controller;

import cl.playground.SpringSecurityBackend.dto.AlumnoResponseDto;
import cl.playground.SpringSecurityBackend.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<Page<AlumnoResponseDto>> findAllAlumnos(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
        ) {
        Page<AlumnoResponseDto> alumnos = alumnoService.findAll(page, size);
        return ResponseEntity.ok(alumnos);
    }
}
