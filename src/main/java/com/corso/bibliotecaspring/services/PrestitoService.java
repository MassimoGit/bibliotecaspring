package com.corso.bibliotecaspring.services;

import com.corso.bibliotecaspring.entities.Book;
import com.corso.bibliotecaspring.entities.Lent;
import com.corso.bibliotecaspring.entities.User;
import com.corso.bibliotecaspring.exceptions.ResourceNotFoundException;
import com.corso.bibliotecaspring.models.request.PrestitoRequestDTO;
import com.corso.bibliotecaspring.models.response.LentResponseDTO;
import com.corso.bibliotecaspring.repositories.BookRepository;
import com.corso.bibliotecaspring.repositories.LentRepository;
import com.corso.bibliotecaspring.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PrestitoService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final LentRepository lentRepository;

    public PrestitoService(UserRepository userRepository,
                           BookRepository bookRepository,
                           LentRepository lentRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.lentRepository = lentRepository;
    }

    // Crea un nuovo prestito e restituisce il DTO del prestito appena creato
    public LentResponseDTO addPrestito(PrestitoRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Utente non trovato con id: " + dto.getUserId()));

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Libro non trovato con id: " + dto.getBookId()));

        Lent lent = new Lent();
        lent.setUser(user);
        lent.setBook(book);
        lent.setInizioPrestito(dto.getInizioPrestito());
        lent.setFinePrestito(dto.getFinePrestito());

        Lent saved = lentRepository.save(lent);
        return toDTO(saved);
    }

    // Converte l'entity Lent nel DTO di risposta
    public LentResponseDTO toDTO(Lent lent) {
        LentResponseDTO dto = new LentResponseDTO();
        dto.setId(lent.getId());
        dto.setBookId(lent.getBook().getId());
        dto.setBookTitle(lent.getBook().getTitle());
        dto.setBookAuthor(lent.getBook().getAuthor());
        dto.setBookIsbn(lent.getBook().getIsbn());
        dto.setInizioPrestito(lent.getInizioPrestito());
        dto.setFinePrestito(lent.getFinePrestito());
        return dto;
    }
}
