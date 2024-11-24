package com.example.todoapp.borders.requests.tasks;
import com.example.todoapp.borders.utils.mediator.interfaces.commands.ICommand;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import com.example.todoapp.borders.utils.constants.Messages;

/**
 * Command for creating a new Task
 */
public class CreateTaskCommand implements ICommand {
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private String title;
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private String description;
    @JsonIgnore
    private UUID userID;
    private LocalDateTime expectedCloseDate;

    /**
     * Create a new CreateTaskCommand
     */
    public CreateTaskCommand() {}

    /**
     * Create a new CreateTaskCommand
     */
    public CreateTaskCommand(String title, String description, LocalDateTime expectedCloseDate) {
        this.title = title;
        this.description = description;
        this.expectedCloseDate = expectedCloseDate;
    }

    /**
     * Get title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get user id
     * @return
     */
    public UUID getUserID() {
        return userID;
    }

    /**
     * Set user id
     * @param userID
     */
    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    /**
     * Get expected close date
     * @return
     */
    public LocalDateTime getExpectedCloseDate() {
        return expectedCloseDate;
    }
}
