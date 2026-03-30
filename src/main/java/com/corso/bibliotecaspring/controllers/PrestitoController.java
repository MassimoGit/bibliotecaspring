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

      @PostMapping
    public ResponseEntity<LentResponseDTO> addPrestito(@RequestBody PrestitoRequestDTO dto) {
        LentResponseDTO result = prestitoService.addPrestito(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
