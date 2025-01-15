package cl.playground.SpringSecurityBackend.auth.controller;

import cl.playground.SpringSecurityBackend.auth.dto.UserChangeStatusDTO;
import cl.playground.SpringSecurityBackend.auth.dto.UserResponseDTO;
import cl.playground.SpringSecurityBackend.auth.model.User;
import cl.playground.SpringSecurityBackend.auth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        List<UserResponseDTO> users = userService.findAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> changeStatus(@PathVariable Long userId, @RequestBody UserChangeStatusDTO status) {
        UserResponseDTO user = userService.changeUserStatus(userId, status);

        return ResponseEntity.ok(user);
    }

}
