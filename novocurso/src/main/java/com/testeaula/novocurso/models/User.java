package com.testeaula.novocurso.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "tb_user")
public class User {

    public interface CreateUser{}
    public interface UpdateUser{}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username")//, length = 100, nullable = false, unique = true )
    private String username;
    
    @Column(name = "password")//, length = 60, nullable = false )
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> task = new ArrayList<Task>();


    public User() {
    }

    public User(Long id, String username, String password, List<Task> task) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.task = task;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public List<Task> getTask() {
        return this.task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public User id(Long id) {
        setId(id);
        return this;
    }

    public User username(String username) {
        setUsername(username);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User task(List<Task> task) {
        setTask(task);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && 
        Objects.equals(password, user.password) && Objects.equals(task, user.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, task);
    }

}