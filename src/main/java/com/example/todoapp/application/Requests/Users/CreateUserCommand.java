package com.example.todoapp.application.Requests.Users;
import com.example.todoapp.Utils.Constants.Messages;
import com.example.todoapp.Utils.CustomAttributes.Validators.DateBefore;
import com.example.todoapp.Utils.CustomAttributes.Validators.ValidDate;
import com.example.todoapp.Utils.Mediator.Interfaces.Commands.ICommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

public class CreateUserCommand implements ICommand {
    @Email(message = Messages.E_MAIL_MUST_BE_VALID)
    private String email;
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private String name;
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private String lastName;
    @DateBefore(value = "10", message = Messages.MIN_AGE_FOR_REGISTERING)
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private LocalDate bornDate;
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private String phoneNumber;

    public static final CreateUserCommand fromJson(String json) {
        return new ObjectMapper().convertValue(json, CreateUserCommand.class);
    }

    public CreateUserCommand(String email, String name, String lastName, LocalDate bornDate, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
}
