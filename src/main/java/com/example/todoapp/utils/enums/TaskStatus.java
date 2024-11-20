package com.example.todoapp.utils.enums;

public enum TaskStatus {
    CREATED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED;

    public String getTaskStatus(){
        return this.name();
    }
}
