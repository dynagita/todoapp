package com.example.todoapp.domain.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Entity who represents a User
 */
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

    /**
     * Create a new User
     */
    public User(){
        super();
        userTasks = new ArrayList<Task>();
    }

    /**
     * Create a new user
     * @param email
     * @param name
     * @param lastName
     * @param bornDate
     * @param phoneNumber
     */
    public User(String email, String name, String lastName, LocalDate bornDate, String phoneNumber) {
        this();
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Create a new user
     * @param id
     * @param email
     * @param name
     * @param lastName
     * @param bornDate
     * @param phoneNumber
     * @param createdAt
     * @param updatedAt
     */
    public User(UUID id, String email, String name, String lastName, LocalDate bornDate, String phoneNumber, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this(email, name, lastName, bornDate, phoneNumber);
        setId(id);
        setUpdatedAt(updatedAt);
        setCreatedAt(createdAt);
    }

    /**
     * Get e-mail
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get born date
     * @return
     */
    public LocalDate getBornDate() {
        return bornDate;
    }

    /**
     * Get tasks
     * @return
     */
    public List<Task> getUserTasks() {
        return userTasks;
    }

    /**
     * Get phone number
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
