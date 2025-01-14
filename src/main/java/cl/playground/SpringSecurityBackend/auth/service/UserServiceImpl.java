package cl.playground.SpringSecurityBackend.auth.service;

import cl.playground.SpringSecurityBackend.auth.dto.UserChangeStatusDTO;
import cl.playground.SpringSecurityBackend.auth.dto.UserCreateDTO;
import cl.playground.SpringSecurityBackend.auth.dto.UserResponseDTO;
import cl.playground.SpringSecurityBackend.auth.mapper.UserMapper;
import cl.playground.SpringSecurityBackend.auth.model.Role;
import cl.playground.SpringSecurityBackend.auth.model.User;
import cl.playground.SpringSecurityBackend.auth.repository.RoleRepository;
import cl.playground.SpringSecurityBackend.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository,
            @Lazy PasswordEncoder passwordEncoder // hay un error aqui  // TRANMQUI // :D
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setUsername(userCreateDTO.getUsername());
        user.setRut(userCreateDTO.getRut());
        user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        user.setEmail(userCreateDTO.getEmail());
        user.setActive(true);
        user.setRoles(mapRoles(userCreateDTO.getRoles()));

        User userSaved = userRepository.save(user);

        return UserMapper.toDTO(userSaved);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO getUserByID(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDTO(user);
    }

    @Override
    @Transactional
    public UserResponseDTO changeUserStatus(Long userId, UserChangeStatusDTO userChangeStatusDTO) {
        // Obtenemos un usuario de la BD y lo guardamos en una variabla
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Verificamos que contengamos un valor para modificar al usuario
        if (userChangeStatusDTO.getIsActive() != null) {
            user.setActive(userChangeStatusDTO.getIsActive());

            User updatedUser = userRepository.save(user);

            // Si funciona se retorna el usuario modificado en estado
            return UserMapper.toDTO(updatedUser);
        } else {

            // Si no funciona le retornamos el usuario que ya existia
            return UserMapper.toDTO(user);
        }
    }

    @Override
    public List<UserResponseDTO> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    private Set<Role> mapRoles(Set<String> roleNames) {
        return roleNames.stream()
                .map(name -> roleRepository.findByName(name.toUpperCase())
                        .orElseThrow(() -> new RuntimeException("Role not found: " + name)))
                .collect(Collectors.toSet());
    }
}
