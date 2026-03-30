package com.corso.bibliotecaspring.models.response;

import lombok.Data;

@Data
public class BookResponseDTO {

    private Long id;
    private String title;
    private String author;
    private String isbn;
}
