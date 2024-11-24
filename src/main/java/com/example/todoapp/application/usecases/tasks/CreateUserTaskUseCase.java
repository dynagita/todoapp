package com.example.todoapp.application.usecases.tasks;

import com.example.todoapp.borders.requests.tasks.CreateTaskCommand;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.tasks.DetailedTaskResponse;
import com.example.todoapp.borders.usecases.tasks.ICreateUserTaskUseCase;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CreateUserTaskUseCase implements ICreateUserTaskUseCase {
    @Override
    public CompletableFuture<Response<DetailedTaskResponse>> handle(CreateTaskCommand query) {
        return CompletableFuture.supplyAsync(()->{

            return null;
        });
    }
}
