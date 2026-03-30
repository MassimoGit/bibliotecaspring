package com.corso.bibliotecaspring.models.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDetailResponseDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private List<BookResponseDTO> lent; // libri attualmente in prestito
}
