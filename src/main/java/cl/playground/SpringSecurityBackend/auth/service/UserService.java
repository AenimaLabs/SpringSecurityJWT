package cl.playground.SpringSecurityBackend.auth.service;


import cl.playground.SpringSecurityBackend.auth.dto.UserChangeStatusDTO;
import cl.playground.SpringSecurityBackend.auth.dto.UserCreateDTO;
import cl.playground.SpringSecurityBackend.auth.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserCreateDTO userCreateDTO);
    UserResponseDTO getUserByID(Long userId);
    UserResponseDTO changeUserStatus(Long userId, UserChangeStatusDTO userChangeStatusDTO);
    List<UserResponseDTO> findAllUsers();
}
