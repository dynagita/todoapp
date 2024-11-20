package com.example.todoapp.application.requests.tasks;

import com.example.todoapp.utils.constants.Messages;
import com.example.todoapp.utils.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;

/**
 * Command for updating task
 */
public class UpdateTaskCommand {
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private String title;
    private String description;
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private TaskStatus status;

    /**
     * Create a new UpdateTaskCommand
     */
    public UpdateTaskCommand() {}

    /**
     * Create a new UpdateTaskCommand
     */
    public UpdateTaskCommand(String title, String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    /**
     * Get title
     *
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
     * Get status
     * @return
     */
    public TaskStatus getStatus() {
        return status;
    }
}
