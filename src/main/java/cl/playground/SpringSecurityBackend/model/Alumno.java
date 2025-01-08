package cl.playground.SpringSecurityBackend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.HashSet;
import java.util.Set;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alumnos",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_alumnos_rut",
            columnNames = {"rut"}
        )
    })
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rut", nullable = false, length = 50)
    private String rut;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @OneToMany(
        mappedBy = "alumno",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private Set<Materia> materias = new HashSet<>();

}