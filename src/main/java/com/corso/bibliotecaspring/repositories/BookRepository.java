package com.corso.bibliotecaspring.repositories;

import com.corso.bibliotecaspring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
