package cl.playground.SpringSecurityBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import lombok.*;

@Entity
@Getter
@Setter
@ToString(exclude = "alumno")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(
        name = "alumno_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_materia_alumno")
    )
    private Alumno alumno;

}