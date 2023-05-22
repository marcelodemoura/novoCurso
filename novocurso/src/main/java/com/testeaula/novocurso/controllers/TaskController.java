package com.testeaula.novocurso.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.testeaula.novocurso.models.Task;
import com.testeaula.novocurso.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {


    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity <Task>findById(@PathVariable Long id){
        Task obj = this.taskService.findById(id);
        return ResponseEntity.ok(obj);
    }
     
    @PostMapping("/{id}")
    public ResponseEntity<Void>create(@Validated @RequestBody Task obj){
        this.taskService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void>update(@Validated @RequestBody Task obj, @PathVariable Long id){
        obj.setId(id);
        this.taskService.updateTask(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>>findAllByUserId(@PathVariable Long userId){
        List<Task> obj = this.taskService.findAllByUserId(userId);
        return ResponseEntity.ok().body(obj);

    }

}
