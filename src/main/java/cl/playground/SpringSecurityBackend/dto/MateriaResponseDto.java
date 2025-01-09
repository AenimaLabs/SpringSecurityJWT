package cl.playground.SpringSecurityBackend.dto;

import cl.playground.SpringSecurityBackend.model.Alumno;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MateriaResponseDto {
    private Long id;
    private String nombre;
    private Alumno alumno;
}
