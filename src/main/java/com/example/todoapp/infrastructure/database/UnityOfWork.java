package com.example.todoapp.infrastructure.database;

import com.example.todoapp.borders.repositories.ITaskRepository;
import com.example.todoapp.borders.repositories.IUnityOfWork;
import com.example.todoapp.borders.repositories.IUserRepository;
import com.example.todoapp.infrastructure.database.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UnityOfWork implements IUnityOfWork {
    private final IUserRepository userRepository;
    private final ITaskRepository taskRepository;

    public UnityOfWork(UserRepository userRepository, ITaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public IUserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public ITaskRepository getTaskRepository() {
        return taskRepository;
    }
}
