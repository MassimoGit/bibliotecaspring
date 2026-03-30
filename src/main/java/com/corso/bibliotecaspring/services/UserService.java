package com.corso.bibliotecaspring.services;

import com.corso.bibliotecaspring.models.response.BookResponseDTO;
import com.corso.bibliotecaspring.models.response.UserDetailResponseDTO;
import com.corso.bibliotecaspring.models.response.UserResponseDTO;
import com.corso.bibliotecaspring.entities.Book;
import com.corso.bibliotecaspring.entities.User;
import com.corso.bibliotecaspring.exceptions.ResourceNotFoundException;
import com.corso.bibliotecaspring.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> result = new ArrayList<>();
        for (User user : users) {
            result.add(toDTO(user));
        }
        return result;
    }

    // Restituisce il dettaglio utente con la lista dei libri attualmente in prestito
    public UserDetailResponseDTO findDetailById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utente non trovato con id: " + id));
        return toDetailDTO(user);
    }

    // Riceve l'entity direttamente dal controller (bad practice: nessuna validazione)
    public UserResponseDTO create(User user) {
        User saved = userRepository.save(user);
        return toDTO(saved);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utente non trovato con id: " + id));
        userRepository.delete(user);
    }

    // Converte l'entity User nel DTO semplice (senza lista libri)
    public UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }

    // Converte l'entity User nel DTO di dettaglio (con lista libri in prestito)
    public UserDetailResponseDTO toDetailDTO(User user) {
        UserDetailResponseDTO dto = new UserDetailResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());

        List<BookResponseDTO> bookDTOs = new ArrayList<>();
        for (Book book : user.getLent()) {
            BookResponseDTO bookDTO = new BookResponseDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthor(book.getAuthor());
            bookDTO.setIsbn(book.getIsbn());
            bookDTOs.add(bookDTO);
        }
        dto.setLent(bookDTOs);
        return dto;
    }
}
