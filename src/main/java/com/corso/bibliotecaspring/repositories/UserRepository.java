package com.corso.bibliotecaspring.repositories;

import com.corso.bibliotecaspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
