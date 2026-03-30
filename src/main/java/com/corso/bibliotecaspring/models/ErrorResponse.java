package com.corso.bibliotecaspring.models;

// Classe semplice per restituire un messaggio di errore strutturato
// Non usiamo Lombok qui: getters e costruttore scritti a mano (bad practice intenzionale)
public class ErrorResponse {

    private int status;
    private String message;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
