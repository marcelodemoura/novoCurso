package com.testeaula.novocurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testeaula.novocurso.models.Task;

@Repository
public interface TaskReposytory extends JpaRepository<Task, Long> {
    

}
