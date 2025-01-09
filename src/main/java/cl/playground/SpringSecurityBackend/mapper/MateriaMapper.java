package cl.playground.SpringSecurityBackend.mapper;

import cl.playground.SpringSecurityBackend.dto.MateriaCreateDTO;
import cl.playground.SpringSecurityBackend.dto.MateriaResponseDto;
import cl.playground.SpringSecurityBackend.model.Materia;
import cl.playground.SpringSecurityBackend.model.Alumno;


public class MateriaMapper {
    public static MateriaResponseDto toDto(Materia materia) {
        if (materia == null) {
            return null;
        }

        return MateriaResponseDto.builder()
                .id(materia.getId())
                .nombre(materia.getNombre())
                .alumno(materia.getAlumno())
                .build();
    }


    public static Materia toMateria(MateriaCreateDTO materiaCreateDTO) {
        if (materiaCreateDTO == null || materiaCreateDTO.getAlumno() == null) {
            return null;
        }

        Materia materia = new Materia();
        materia.setNombre(materiaCreateDTO.getNombre());
        return materia;
    }
}


