package com.example.todoapp.application.UseCases.Users.CreateUser;
import com.example.todoapp.Utils.Mediator.Interfaces.Commands.ICommand;
import java.util.Date;

public class CreateUserCommand implements ICommand {
    private String email;
    private String name;
    private String lastName;
    private Date bornDate;
    private String phoneNumber;

    public CreateUserCommand(String email, String name, String lastName, Date bornDate, String phoneNumber) {
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

    public Date getBornDate() {
        return bornDate;
    }
}
