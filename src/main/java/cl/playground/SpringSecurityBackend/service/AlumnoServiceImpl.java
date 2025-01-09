package cl.playground.SpringSecurityBackend.service;

import cl.playground.SpringSecurityBackend.dto.AlumnoCreateDTO;
import cl.playground.SpringSecurityBackend.dto.AlumnoResponseDto;
import cl.playground.SpringSecurityBackend.mapper.AlumnoMapper;
import cl.playground.SpringSecurityBackend.repository.AlumnoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import cl.playground.SpringSecurityBackend.model.Alumno;

@Service
@Log4j2
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Page<AlumnoResponseDto> findAll(int page, int size) {
        log.info("Fetching all students with pagination: page=" + page + ", size=" + size);
        Pageable pageable = PageRequest.of(page, size);

        Page<Alumno> alumnos = alumnoRepository.findAll(pageable);
        log.info("Retrieved " + alumnos.getTotalElements() + " students from the database.");

        Page<AlumnoResponseDto> response = alumnos.map(AlumnoMapper::toDto);
        log.info("Returning " + response.getTotalElements() + " students to the client.");

       // List<AlumnoResponseDto> alumnoList = alumnos.getContent()
        ///                                            .stream()


        return response;
    }

    @Override
    public void saveAlumno(AlumnoCreateDTO alumnoCreateDto) {
        log.info("Saving  a new student: " + alumnoCreateDto);
        if (alumnoCreateDto != null) {
            Alumno alumno = AlumnoMapper.toAlumno(alumnoCreateDto);
            alumnoRepository.save(alumno);
        }
    }

}
