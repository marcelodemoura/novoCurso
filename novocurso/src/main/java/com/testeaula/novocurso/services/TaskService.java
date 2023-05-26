package com.testeaula.novocurso.services;

import java.util.List;
import java.util.Optional;

import com.testeaula.novocurso.services.exceptions.DataBindingViolationException;
import com.testeaula.novocurso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testeaula.novocurso.models.Task;
import com.testeaula.novocurso.models.User;
import com.testeaula.novocurso.repositories.TaskReposytory;


@Service
public class TaskService {
    
@Autowired
private TaskReposytory taskReposytory;

@Autowired
private UserService userService;

public Task findById(Long id){
    Optional<Task> task = this.taskReposytory.findById(id);
    return task.orElseThrow(() -> new ObjectNotFoundException(
            "Tarefa não encontrada!" + id + ",Tipo: " + Task.class.getName()));
}

public List<Task>findAllByUserId(Long userId){
    List<Task>tasks = this.taskReposytory.findByUser_Id(userId);
    return tasks;
}

@Transactional
public Task create(Task obj){
    User user = this.userService.findById(obj.getUser().getId());
    obj.setId(null);
    obj.setUser(user);
    obj = this.taskReposytory.save(obj);
    return obj;
}
@Transactional
public Task updateTask(Task obj){
    Task newObj = findById(obj.getId());
    newObj.setDescription(obj.getDescription());
    return this.taskReposytory.save(newObj);

}

public void delete(Long id){
    findById(id);
    try{
        this.taskReposytory.deleteById(id);  
    }catch(Exception e){
        throw new DataBindingViolationException("Não é possivel excluir pois a entidade eatá relacionada! ");
    }
}

}
