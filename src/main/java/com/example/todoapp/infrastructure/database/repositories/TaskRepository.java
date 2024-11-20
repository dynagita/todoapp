package com.example.todoapp.infrastructure.database.repositories;

import com.example.todoapp.domain.models.Task;
import com.example.todoapp.domain.repositories.ITaskRepository;

/**
 * Task repository
 */
@org.springframework.stereotype.Repository
public class TaskRepository extends Repository<Task> implements ITaskRepository {
    public TaskRepository() {
        super(Task.class);
    }
}
