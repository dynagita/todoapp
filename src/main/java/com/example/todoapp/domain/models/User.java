package com.example.todoapp.domain.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="todo_users")
public class User extends EntityBase{
    private String username;
    private String email;
    private String name;
    private String lastName;
    private Date bornDate;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> userTasks;


    public User(){
        super();
        userTasks = new ArrayList<Task>();
    }

    public User(String username, String email, String name, String lastName, Date bornDate) {
        this();
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.bornDate = bornDate;
    }

    public User(UUID id, String username, String email, String name, String lastName, Date bornDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        setId(id);
        setUpdatedAt(updatedAt);
        setCreatedAt(createdAt);
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.bornDate = bornDate;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public List<Task> getUserTasks() {
        return userTasks;
    }
}
