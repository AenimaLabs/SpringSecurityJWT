package cl.playground.SpringSecurityBackend.auth.service;

import cl.playground.SpringSecurityBackend.auth.model.Role;
import cl.playground.SpringSecurityBackend.auth.model.User;
import cl.playground.SpringSecurityBackend.auth.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));


        System.out.println("User loaded: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Roles: " + user.getRoles());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );
    }

    public Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName().toUpperCase()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public boolean userExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Transactional(readOnly = true)
    public boolean isUserActive(String username) {
        return userRepository.findByUsername(username)
                .map(User::getActive)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    @Transactional(readOnly = true)
    public String getUserRole(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        if (!user.getActive()) {
            throw new RuntimeException("User is not active: " + username);
        }

        return user.getRoles().stream()
                .findFirst()
                .map(Role::getName)
                .orElse("ADMIN");
    }
}
