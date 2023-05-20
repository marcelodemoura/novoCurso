package com.testeaula.novocurso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testeaula.novocurso.models.User;
import com.testeaula.novocurso.repositories.TaskReposytory;
import com.testeaula.novocurso.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(()-> new RuntimeException
        ("Usuario não encontrado! Id:"+ id + ",Tipo" + User.class.getName()));

    }
    
    @Autowired
    private TaskReposytory taskReposytory;


    @Transactional
    public User create(User obj) {
        obj.setId(null);
        obj = this.userRepository.save(obj);
        this.taskReposytory.saveAll(obj.getTask());
        return obj;
    }

    @Transactional
    public User update(User obj) {
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try{

            this.userRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Não e possivel excluir a relacionamento entre a entidade! ");
        }
    }





}

