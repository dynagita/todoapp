package com.example.todoapp.application.usecases.tasks;

import com.example.todoapp.borders.mappers.TaskMap;
import com.example.todoapp.borders.repositories.ITaskRepository;
import com.example.todoapp.borders.repositories.IUserRepository;
import com.example.todoapp.borders.requests.tasks.CreateTaskCommand;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.tasks.DetailedTaskResponse;
import com.example.todoapp.borders.usecases.tasks.ICreateUserTaskUseCase;
import com.example.todoapp.borders.utils.constants.Messages;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CreateUserTaskUseCase implements ICreateUserTaskUseCase {

    private final IUserRepository userRepository;
    private final ITaskRepository taskRepository;

    public CreateUserTaskUseCase(IUserRepository userRepository, ITaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }
    @Override
    public CompletableFuture<Response<DetailedTaskResponse>> handle(CreateTaskCommand query) {
        return CompletableFuture.supplyAsync(()->{
            var user = userRepository.findById(query.getUserID());
            if(user == null) {
                return Response.ProduceNotFoundResult("user", Messages.NOT_FOUND);
            }
            var task = TaskMap.mapTask(query, user);

            taskRepository.save(task);

            return Response.ProduceSuccessResult(TaskMap.mapTaskResponse(task));
        });
    }
}
