package cl.playground.SpringSecurityBackend.service;

import cl.playground.SpringSecurityBackend.dto.MateriaCreateDTO;
import cl.playground.SpringSecurityBackend.dto.MateriaResponseDto;
import cl.playground.SpringSecurityBackend.mapper.MateriaMapper;
import cl.playground.SpringSecurityBackend.model.Alumno;
import cl.playground.SpringSecurityBackend.model.Materia;
import cl.playground.SpringSecurityBackend.repository.AlumnoRepository;
import cl.playground.SpringSecurityBackend.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MateriaServicelmpl implements MateriaService {

    @Autowired
    private  MateriaRepository materiaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Page<MateriaResponseDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void saveMateria(MateriaCreateDTO materiaCreateDTO) {
        Materia materia = MateriaMapper.toMateria(materiaCreateDTO);
        Optional<Alumno> alumno = alumnoRepository.findById(materiaCreateDTO.getAlumno());
        if (alumno.isPresent()) {
            materia.setAlumno(alumno.get());
        }
        materiaRepository.save(materia);
    }
}
