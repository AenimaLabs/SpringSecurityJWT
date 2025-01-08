package cl.playground.SpringSecurityBackend.repository;

import cl.playground.SpringSecurityBackend.model.Alumno;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@SpringBootTest
@Transactional
class AlumnoRepositoryTest {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Test
    void getAllAlumnos() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Alumno> alumnos = alumnoRepository.findAll(pageable);

        alumnos.forEach(System.out::println);
    }


}