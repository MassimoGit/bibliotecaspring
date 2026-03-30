package com.corso.bibliotecaspring.controllers;

import com.corso.bibliotecaspring.models.response.UserDetailResponseDTO;
import com.corso.bibliotecaspring.models.request.UserRequestDTO;
import com.corso.bibliotecaspring.models.response.UserResponseDTO;
import com.corso.bibliotecaspring.services.UserService;
import jakarta.validation.Valid;
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

    // GET /api/utenti — restituisce la lista di tutti gli utenti registrati
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    // GET /api/utenti/{id} — restituisce i dati anagrafici + lista libri in prestito
    @GetMapping("/{id}")
    public ResponseEntity<UserDetailResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findDetailById(id));
    }

    // POST /api/utenti — registra un nuovo utente
    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

    // DELETE /api/utenti/{id} — elimina un utente dal sistema
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
