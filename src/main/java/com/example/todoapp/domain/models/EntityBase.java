package com.example.todoapp.domain.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base entity with common fields
 */
@MappedSuperclass
public class EntityBase {
    @Id
    protected UUID id;
    @CreatedDate
    protected LocalDateTime createdAt;
    @LastModifiedDate
    protected LocalDateTime updatedAt;

    /**
     * Create a new EntityBase
     */
    public EntityBase(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        id = UUID.randomUUID();
    }

    /**
     * Get id
     * @return
     */
    public UUID getId() {
        return id;
    }

    /**
     * Get created at
     * @return
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Get updated at
     * @return
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Set updated at
     * @param updatedAt
     */
    protected void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Set id
     * @param id
     */
    protected void setId(UUID id) {
        this.id = id;
    }

    /**
     * Set created at
     * @param createdAt
     */
    protected void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
