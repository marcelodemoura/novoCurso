package com.testeaula.novocurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.testeaula.novocurso.models.Task;

public interface TaskReposytory extends JpaRepository<Task, Long> {
    

}
