package cl.playground.SpringSecurityBackend.service;

import cl.playground.SpringSecurityBackend.dto.MateriaCreateDTO;
import cl.playground.SpringSecurityBackend.dto.MateriaResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MateriaService {

    Page<MateriaResponseDto> findAll(Pageable pageable);

    void saveMateria(MateriaCreateDTO materiaCreateDTO);

}
