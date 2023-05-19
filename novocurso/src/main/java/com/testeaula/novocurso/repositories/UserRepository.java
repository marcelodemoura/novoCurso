package com.testeaula.novocurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.testeaula.novocurso.models.User;


public interface UserRepository extends JpaRepository<User,Long> {
    
}
