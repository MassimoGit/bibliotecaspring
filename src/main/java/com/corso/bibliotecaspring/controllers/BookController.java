package com.corso.bibliotecaspring.controllers;

import com.corso.bibliotecaspring.models.request.BookRequestDTO;
import com.corso.bibliotecaspring.models.response.BookResponseDTO;
import com.corso.bibliotecaspring.services.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libri")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET /api/libri — restituisce tutti i libri disponibili nel catalogo
    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    // POST /api/libri — aggiunge un nuovo libro al catalogo
    @PostMapping
    public ResponseEntity<BookResponseDTO> create(@Valid @RequestBody BookRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(dto));
    }

    // DELETE /api/libri/{id} — rimuove un libro dal catalogo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
