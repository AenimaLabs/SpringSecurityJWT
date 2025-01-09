package cl.playground.SpringSecurityBackend.dto;


import cl.playground.SpringSecurityBackend.model.Alumno;
import lombok.*;
import java.util.Set;

@Getter
@Setter
@ToString()
@NoArgsConstructor
@AllArgsConstructor
public class MateriaCreateDTO {

    private String nombre;

    private Long alumno;

}
