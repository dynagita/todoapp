package com.example.todoapp.borders.requests.users;
import com.example.todoapp.borders.utils.constants.Messages;
import com.example.todoapp.borders.utils.customattributes.validators.DateBefore;
import com.example.todoapp.borders.utils.customattributes.validators.PhoneNumber;
import com.example.todoapp.borders.utils.mediator.interfaces.commands.ICommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Command for creating a new User
 */
public class CreateUserCommand implements ICommand {
    @Email(message = Messages.E_MAIL_MUST_BE_VALID)
    private String email;
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private String name;
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private String lastName;
    @DateBefore(value = "10", message = Messages.MIN_AGE_FOR_REGISTERING)
    private LocalDate bornDate;
    @PhoneNumber(regexPattern = "([(][1-9]{2}[)])[9]?([1-9]{4})[-]?([0-9]{4})", message = Messages.BRAZILIAN_NUMBER_REQUIRED)
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private String phoneNumber;

    /**
     * Parse a CreateUserCommand json
     * @param json
     * @return object
     */
    public static final CreateUserCommand fromJson(String json) {
        return new ObjectMapper().convertValue(json, CreateUserCommand.class);
    }

    /**
     * Create a new CreateUserCommand
     * @param email
     * @param name
     * @param lastName
     * @param bornDate
     * @param phoneNumber
     */
    public CreateUserCommand(String email, String name, String lastName, LocalDate bornDate, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get phone number
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
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
}
