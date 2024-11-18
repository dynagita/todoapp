package com.example.todoapp.application.Responses.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class UserResponse {
    private UUID id;
    private String name;
    private String email;
    private String lastName;
    private LocalDate bornDate;
    private String phoneNumber;

    public UserResponse(UUID id, String name, String email, String lastName, LocalDate bornDate, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}
