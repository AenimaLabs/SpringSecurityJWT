package cl.playground.SpringSecurityBackend.service;

import cl.playground.SpringSecurityBackend.dto.AlumnoCreateDTO;
import cl.playground.SpringSecurityBackend.dto.AlumnoResponseDto;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface AlumnoService {

    Page<AlumnoResponseDto> findAll(int page, int size);

    void saveAlumno(AlumnoCreateDTO alumnoResponseDto);
}
