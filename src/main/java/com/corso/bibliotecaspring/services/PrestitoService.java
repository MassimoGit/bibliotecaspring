package com.corso.bibliotecaspring.services;

import com.corso.bibliotecaspring.models.response.UserDetailResponseDTO;
import com.corso.bibliotecaspring.entities.Book;
import com.corso.bibliotecaspring.entities.User;
import com.corso.bibliotecaspring.exceptions.ResourceNotFoundException;
import com.corso.bibliotecaspring.repositories.BookRepository;
import com.corso.bibliotecaspring.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PrestitoService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final UserService userService;

    public PrestitoService(UserRepository userRepository,
                           BookRepository bookRepository,
                           UserService userService) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.userService = userService;
    }

    // Aggiunge un libro alla lista dei prestiti dell'utente e restituisce il dettaglio aggiornato
    public UserDetailResponseDTO addPrestito(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Utente non trovato con id: " + userId));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Libro non trovato con id: " + bookId));

        // Aggiunge il libro alla lista prestiti dell'utente (lato owner della relazione)
        if (!user.getLent().contains(book)) {
            user.getLent().add(book);
            userRepository.save(user);
        }

        return userService.toDetailDTO(user);
    }
}
