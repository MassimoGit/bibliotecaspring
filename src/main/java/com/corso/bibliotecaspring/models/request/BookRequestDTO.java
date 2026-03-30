package com.corso.bibliotecaspring.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequestDTO {

    @NotBlank(message = "Il titolo è obbligatorio")
    private String title;

    @NotBlank(message = "L'autore è obbligatorio")
    private String author;

    @NotBlank(message = "L'ISBN è obbligatorio")
    private String isbn;
}
