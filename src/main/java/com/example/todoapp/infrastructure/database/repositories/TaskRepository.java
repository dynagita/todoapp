package com.example.todoapp.infrastructure.database.repositories;

import com.example.todoapp.borders.models.Task;
import com.example.todoapp.borders.repositories.ITaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Task repository
 */
@org.springframework.stereotype.Repository
public class TaskRepository extends Repository<Task> implements ITaskRepository {
    public TaskRepository() {
        super(Task.class);
    }
}
