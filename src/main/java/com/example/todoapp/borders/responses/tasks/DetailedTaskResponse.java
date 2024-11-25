package com.example.todoapp.borders.responses.tasks;

import com.example.todoapp.borders.mappers.UserMap;
import com.example.todoapp.borders.models.Task;
import com.example.todoapp.borders.responses.user.UserResponse;
import com.example.todoapp.borders.utils.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Detailed task response
 */
public class DetailedTaskResponse {
    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private UserResponse user;
    private LocalDateTime createdDate;
    private LocalDateTime expectedCloseDate;
    private LocalDateTime actualCloseDate;

    /**
     * Allow create a new detailed task response
     * @param id
     * @param title
     * @param description
     * @param status
     * @param user
     * @param createdDate
     * @param expectedCloseDate
     */
    public DetailedTaskResponse(UUID id, String title, String description, TaskStatus status, UserResponse user, LocalDateTime createdDate, LocalDateTime expectedCloseDate, LocalDateTime actualCloseDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.user = user;
        this.createdDate = createdDate;
        this.expectedCloseDate = expectedCloseDate;
        this.actualCloseDate = actualCloseDate;
    }

    /**
     * Allow create a new detailed task response
     * @param task
     */
    public DetailedTaskResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.user = UserMap.mapUserResponse(task.getUser());
        this.createdDate = task.getCreatedAt();
        this.expectedCloseDate = task.getExpectedCloseDate();
        this.actualCloseDate = task.getActualCloseDate();
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
     * Get expected close date
     * @return
     */
    public LocalDateTime getExpectedCloseDate() {
        return expectedCloseDate;
    }

    /**
     * Get actual close date
     * @return
     */
    public LocalDateTime getActualCloseDate() {
        return actualCloseDate;
    }

    /**
     * Get id
     * @return
     */
    public UUID getId() {
        return id;
    }
}
