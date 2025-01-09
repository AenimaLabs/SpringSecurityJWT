package cl.playground.SpringSecurityBackend.dto;

import lombok.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoCreateDTO {

    private String rut;

    private String nombre;

    private String direccion;

    private Set<Long> materiaIds;  // IDs de las materias asociadas
}
