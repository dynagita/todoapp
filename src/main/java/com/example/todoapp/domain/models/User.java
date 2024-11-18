package com.example.todoapp.domain.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="todo_users")
public class User extends EntityBase{
    private String email;
    private String name;
    private String lastName;
    private LocalDate bornDate;
    private String phoneNumber;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> userTasks;


    public User(){
        super();
        userTasks = new ArrayList<Task>();
    }

    public User(String email, String name, String lastName, LocalDate bornDate, String phoneNumber) {
        this();
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
    }

    public User(UUID id, String email, String name, String lastName, LocalDate bornDate, String phoneNumber, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this(email, name, lastName, bornDate, phoneNumber);
        setId(id);
        setUpdatedAt(updatedAt);
        setCreatedAt(createdAt);
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

    public LocalDate getBornDate() {
        return bornDate;
    }

    public List<Task> getUserTasks() {
        return userTasks;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
