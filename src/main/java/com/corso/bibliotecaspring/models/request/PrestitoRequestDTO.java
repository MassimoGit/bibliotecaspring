package com.corso.bibliotecaspring.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PrestitoRequestDTO {

    @NotNull(message = "L'ID utente è obbligatorio")
    private Long userId;

    @NotNull(message = "L'ID libro è obbligatorio")
    private Long bookId;
}
