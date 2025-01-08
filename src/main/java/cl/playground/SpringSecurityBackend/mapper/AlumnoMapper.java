package cl.playground.SpringSecurityBackend.mapper;

import cl.playground.SpringSecurityBackend.dto.AlumnoResponseDto;
import cl.playground.SpringSecurityBackend.model.Alumno;
import cl.playground.SpringSecurityBackend.model.Materia;

import java.util.stream.Collectors;

public class AlumnoMapper {

    public static AlumnoResponseDto toDto(Alumno alumno) {

        if (alumno == null) {
            return null;
        }

        return AlumnoResponseDto.builder()
            .id(alumno.getId())
            .rut(alumno.getRut())
            .nombre(alumno.getNombre())
            .direccion(alumno.getDireccion())
            .materias(alumno.getMaterias() != null ?
                alumno.getMaterias().stream()
                    .map(Materia::getNombre)
                    .collect(Collectors.toSet()) : null)
            .build();
    }

}
