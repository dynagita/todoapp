package com.example.todoapp.borders.models;

import com.example.todoapp.borders.utils.enums.TaskStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entity who represents a task
 */
@Entity
@Table(name="todo_tasks")
public class Task extends EntityBase{
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 5000)
    private String description;
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    LocalDateTime expectedCloseDate;
    LocalDateTime actualCloseDate;

    /**
     * Create a new task
     */
    public Task(){
        super();
    }

    /**
     * Create a new task
     * @param title
     * @param description
     * @param user
     */
    public Task(String title, String description, User user, LocalDateTime expectedCloseDate) {
        this();
        this.title = title;
        this.description = description;
        this.user = user;
        this.status = TaskStatus.CREATED;
        this.expectedCloseDate = expectedCloseDate;
    }

    /**
     * Create a new task
     * @param id
     * @param title
     * @param description
     * @param status
     * @param user
     * @param createdAt
     * @param updatedAt
     */
    public Task(UUID id, String title, String description, TaskStatus status, User user, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime expectedCloseDate, LocalDateTime actualCloseDate) {
        setId(id);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        this.title = title;
        this.description = description;
        this.status = status;
        this.user = user;
        this.expectedCloseDate = expectedCloseDate;
        this.actualCloseDate = actualCloseDate;
    }

    /**
     * Get title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get done
     * @return
     */
    public TaskStatus getStatus() {
        return status;
    }

    /**
     * Set done
     * @param status
     */
    public void setDone(TaskStatus status) {
        this.status = status;
    }

    /**
     * Get user
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * Get expected close date
     * @return
     */
    public LocalDateTime getExpectedCloseDate(){
        return expectedCloseDate;
    }

    /**
     * Get actual close date
     * @return
     */
    public LocalDateTime getActualCloseDate(){
        return actualCloseDate;
    }
}