package com.example.todoapp.application.responses.tasks;
import com.example.todoapp.application.responses.user.UserResponse;
import com.example.todoapp.utils.enums.TaskStatus;

/**
 * Task response object
 */
public class TaskResponse {
    private String title;
    private String description;
    private TaskStatus status;
    private UserResponse user;

    /**
     * Create a new TaskResponse
     */
    public TaskResponse() {}

    /**
     * Create a new TaskResponse
     */
    public TaskResponse(String title, String description, TaskStatus status, UserResponse user) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.user = user;
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
     * Get status
     * @return
     */
    public TaskStatus getStatus() {
        return status;
    }

    /**
     * Get user
     * @return
     */
    public UserResponse getUser() {
        return user;
    }
}
