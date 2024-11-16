package com.example.todoapp.application.UseCases.User.CreateUser;
import com.example.todoapp.Utils.Mediator.Interfaces.Commands.ICommand;
import java.util.Date;

public class CreateUserCommand implements ICommand {
    private String username;
    private String email;
    private String name;
    private String lastName;
    private Date bornDate;

    public CreateUserCommand(String username, String email, String name, String lastName, Date bornDate) {
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
}
