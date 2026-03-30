package com.corso.bibliotecaspring.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank(message = "Il nome è obbligatorio")
    private String name;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String surname;

    @NotBlank(message = "L'email è obbligatoria")
    private String email;

    @NotBlank(message = "Il telefono è obbligatorio")
    private String phone;
}
