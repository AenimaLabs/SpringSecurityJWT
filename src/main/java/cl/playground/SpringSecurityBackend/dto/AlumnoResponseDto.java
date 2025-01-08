package cl.playground.SpringSecurityBackend.dto;

import cl.playground.SpringSecurityBackend.model.Materia;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlumnoResponseDto {
    private Long id;
    private String rut;
    private String nombre;
    private String direccion;
    private Set<String> materias;
}
