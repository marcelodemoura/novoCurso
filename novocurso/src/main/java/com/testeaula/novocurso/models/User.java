package com.testeaula.novocurso.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;



@Entity
@Table(name = "user")
public class User {

    public interface CreateUser{}
    public interface UpdateUser{}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "username")//, length = 100, nullable = false, unique = true )
    private String username;
    
    @Column(name = "password")//, length = 60, nullable = false )
    private String password;

   //private List<Task> task = new ArrayList<>(null){};


    public User() {
    }


    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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
    @Override
    public boolean equals(Object obj){
        if (obj == this)
            return true;
        if(! obj instanceof User){
            return false;
        }
        User user =(User) obj;
    }
 



}