package com.corso.bibliotecaspring.models.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrestitoRequestDTO {

    private Long userId;
    private Long bookId;
    private LocalDate inizioPrestito;
    private LocalDate finePrestito; // opzionale: può essere null se il prestito è ancora aperto
}
