package com.corso.bibliotecaspring.exceptions;

import com.corso.bibliotecaspring.models.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Gestisce il caso in cui una risorsa (User o Book) non viene trovata nel DB
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        ErrorResponse body = new ErrorResponse(404, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    // Gestisce gli errori di validazione sui campi del DTO (@NotBlank, ecc.)
    // Raccoglie tutti i messaggi di errore in una stringa unica
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getField());
            sb.append(": ");
            sb.append(fieldError.getDefaultMessage());
            sb.append("; ");
        }
        ErrorResponse body = new ErrorResponse(400, sb.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
