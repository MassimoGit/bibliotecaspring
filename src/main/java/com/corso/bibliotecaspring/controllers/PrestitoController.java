package com.corso.bibliotecaspring.controllers;

import com.corso.bibliotecaspring.models.request.PrestitoRequestDTO;
import com.corso.bibliotecaspring.models.response.LentResponseDTO;
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

    // POST /api/prestiti — crea un nuovo prestito
    // Corpo JSON: { "userId": 1, "bookId": 2, "inizioPrestito": "2026-03-30", "finePrestito": "2026-04-30" }
    @PostMapping
    public ResponseEntity<LentResponseDTO> addPrestito(@RequestBody PrestitoRequestDTO dto) {
        LentResponseDTO result = prestitoService.addPrestito(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
