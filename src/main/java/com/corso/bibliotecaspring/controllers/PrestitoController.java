package com.corso.bibliotecaspring.controllers;

import com.corso.bibliotecaspring.models.request.PrestitoRequestDTO;
import com.corso.bibliotecaspring.models.response.UserDetailResponseDTO;
import com.corso.bibliotecaspring.services.PrestitoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestiti")
public class PrestitoController {

    private final PrestitoService prestitoService;

    public PrestitoController(PrestitoService prestitoService) {
        this.prestitoService = prestitoService;
    }

    // POST /api/prestiti — assegna un libro a un utente (nuovo prestito)
    // Il corpo JSON deve contenere: { "userId": 1, "bookId": 2 }
    @PostMapping
    public ResponseEntity<UserDetailResponseDTO> addPrestito(@RequestBody PrestitoRequestDTO dto) {
        UserDetailResponseDTO result = prestitoService.addPrestito(dto.getUserId(), dto.getBookId());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
