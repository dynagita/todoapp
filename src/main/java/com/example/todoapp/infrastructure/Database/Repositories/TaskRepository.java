package com.example.todoapp.infrastructure.Database.Repositories;

import com.example.todoapp.domain.models.Task;
import com.example.todoapp.domain.repositories.ITaskRepository;

public class TaskRepository extends Repository<Task> implements ITaskRepository {
    public TaskRepository() {
        super(Task.class);
    }
}
