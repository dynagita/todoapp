package com.example.todoapp.borders.repositories;

public interface IUnityOfWork {
    IUserRepository getUserRepository();
    ITaskRepository getTaskRepository();
}
