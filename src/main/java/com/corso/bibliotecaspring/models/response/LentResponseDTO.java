package com.corso.bibliotecaspring.models.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LentResponseDTO {

    private Long id;

    // Dati del libro coinvolto nel prestito (flat, senza annidamento)
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookIsbn;

    private LocalDate inizioPrestito;
    private LocalDate finePrestito;
}
