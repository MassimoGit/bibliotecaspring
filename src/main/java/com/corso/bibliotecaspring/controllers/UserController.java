package com.corso.bibliotecaspring.controllers;

import com.corso.bibliotecaspring.entities.User;
import com.corso.bibliotecaspring.models.response.UserDetailResponseDTO;
import com.corso.bibliotecaspring.models.response.UserResponseDTO;
import com.corso.bibliotecaspring.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utenti")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDetailResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findDetailById(id));
    }


    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
