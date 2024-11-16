package com.example.todoapp.domain.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="todo_tasks")
public class Task extends EntityBase{
    @Column(nullable = false)
    private String title;
    private String description;
    private Boolean done;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Task(){
        super();
    }
    public Task(String title, String description, Boolean done, User user) {
        this();
        this.title = title;
        this.description = description;
        this.done = done;
        this.user = user;
    }

    public Task(UUID id, String title, String description, Boolean done, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        setId(id);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        this.title = title;
        this.description = description;
        this.done = done;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}