package cl.playground.SpringSecurityBackend.auth.controller;

import cl.playground.SpringSecurityBackend.auth.dto.AuthenticationRequest;
import cl.playground.SpringSecurityBackend.auth.dto.AuthenticationResponse;
import cl.playground.SpringSecurityBackend.auth.security.JwtUtil;
import cl.playground.SpringSecurityBackend.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, AuthService authService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {

        // VERIFICAMOS SI EL USUARIO PROPORCIONADO EXISTE
        if (!authService.userExist(authenticationRequest.getUsername())) {
            throw new UsernameNotFoundException("User not found: " + authenticationRequest.getUsername());
        }

        // VERIFICAMOS SI EL USUARIO ESTA ACTIVO
        if (!authService.isUserActive(authenticationRequest.getUsername())) {
            throw new RuntimeException("User is not active: " + authenticationRequest.getUsername());
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = jwtUtil.generateToken(userDetails);
        String role = authService.getUserRole(authenticationRequest.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(role, jwt));
    }

}
