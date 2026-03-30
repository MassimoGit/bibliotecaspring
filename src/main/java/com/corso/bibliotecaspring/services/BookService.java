package com.corso.bibliotecaspring.services;

import com.corso.bibliotecaspring.models.request.BookRequestDTO;
import com.corso.bibliotecaspring.models.response.BookResponseDTO;
import com.corso.bibliotecaspring.entities.Book;
import com.corso.bibliotecaspring.exceptions.ResourceNotFoundException;
import com.corso.bibliotecaspring.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponseDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookResponseDTO> result = new ArrayList<>();
        for (Book book : books) {
            result.add(toDTO(book));
        }
        return result;
    }

    public BookResponseDTO create(BookRequestDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        Book saved = bookRepository.save(book);
        return toDTO(saved);
    }

    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro non trovato con id: " + id));
        bookRepository.delete(book);
    }

    // Converte l'entity Book nel DTO di risposta (senza la lista utenti per evitare ricorsione)
    public BookResponseDTO toDTO(Book book) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        return dto;
    }
}
