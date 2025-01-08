package cl.playground.SpringSecurityBackend.repository;

import cl.playground.SpringSecurityBackend.model.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

    Page<Materia> findAll(Pageable pageable);

}
