package com.corso.bibliotecaspring.models.response;

import lombok.Data;

import java.util.List;

@Data
public class UserDetailResponseDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private List<BookResponseDTO> lent; // libri attualmente in prestito
}
