package com.corso.bibliotecaspring.repositories;

import com.corso.bibliotecaspring.entities.Lent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LentRepository extends JpaRepository<Lent, Long> {
}
