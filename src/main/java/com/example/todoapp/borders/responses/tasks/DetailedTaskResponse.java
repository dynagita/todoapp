package com.example.todoapp.borders.responses.tasks;

import com.example.todoapp.borders.mappers.UserMap;
import com.example.todoapp.borders.models.Task;
import com.example.todoapp.borders.responses.user.UserResponse;
import com.example.todoapp.borders.utils.enums.TaskStatus;
import java.time.LocalDateTime;

/**
 * Detailed task response
 */
public class DetailedTaskResponse {
    private String title;
    private String description;
    private TaskStatus status;
    private UserResponse user;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    /**
     * Allow create a new detailed task response
     * @param title
     * @param description
     * @param status
     * @param user
     * @param createdDate
     * @param updatedDate
     */
    public DetailedTaskResponse(String title, String description, TaskStatus status, UserResponse user, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.user = user;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    /**
     * Allow create a new detailed task response
     * @param task
     */
    public DetailedTaskResponse(Task task) {
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.user = UserMap.mapUserResponse(task.getUser());
        this.createdDate = task.getCreatedAt();
        this.updatedDate = task.getUpdatedAt();
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

    /**
     * Get created date
     * @return
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Get updated date
     * @return
     */
    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
}
