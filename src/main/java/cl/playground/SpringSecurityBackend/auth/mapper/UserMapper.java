package cl.playground.SpringSecurityBackend.auth.mapper;

import cl.playground.SpringSecurityBackend.auth.dto.UserResponseDTO;
import cl.playground.SpringSecurityBackend.auth.model.Role;
import cl.playground.SpringSecurityBackend.auth.model.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(
                user.getUserId(),
                user.getUsername(),
                user.getRut(),
                user.getEmail(),
                user.getActive(),
                user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet())
        );
    }
}
