package com.example.todoapp.borders.responses.user;

import java.time.LocalDate;
import java.util.UUID;

/**
 * User response object
 */
public class UserResponse {
    private UUID id;
    private String name;
    private String email;
    private String lastName;
    private LocalDate bornDate;
    private String phoneNumber;

    /**
     * Create a new UserResponse
     * @param id
     * @param name
     * @param email
     * @param lastName
     * @param bornDate
     * @param phoneNumber
     */
    public UserResponse(UUID id, String name, String email, String lastName, LocalDate bornDate, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get id
     * @return
     */
    public UUID getId() {
        return id;
    }

    /**
     * Get name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get e-mail
     * @return
     */
    public String getEmail() {
        return email;
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
     * Get phone number
     * @return
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
