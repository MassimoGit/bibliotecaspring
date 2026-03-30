package com.corso.bibliotecaspring.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDTO {

    @NotBlank(message = "Il titolo è obbligatorio")
    private String title;

    @NotBlank(message = "L'autore è obbligatorio")
    private String author;

    @NotBlank(message = "L'ISBN è obbligatorio")
    private String isbn;
}
