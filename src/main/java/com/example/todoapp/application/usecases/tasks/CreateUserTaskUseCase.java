package com.example.todoapp.application.usecases.tasks;

import com.example.todoapp.application.usecases.CommandHandlerBaseUseCase;
import com.example.todoapp.borders.mappers.TaskMap;
import com.example.todoapp.borders.repositories.IUnityOfWork;
import com.example.todoapp.borders.requests.tasks.CreateTaskCommand;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.tasks.DetailedTaskResponse;
import com.example.todoapp.borders.usecases.tasks.ICreateUserTaskUseCase;
import com.example.todoapp.borders.utils.constants.Messages;
import org.springframework.stereotype.Service;

/**
 * Use case for creating a new user task
 */
@Service
public class CreateUserTaskUseCase extends CommandHandlerBaseUseCase<CreateTaskCommand, DetailedTaskResponse> implements ICreateUserTaskUseCase {

    private final IUnityOfWork uow;

    /**
     * Create a new CreateUserTaskUseCase
     * @param uow
     */
    public CreateUserTaskUseCase(IUnityOfWork uow) {
        this.uow = uow;
    }

    /**
     * Handle use case logic
     * @param command
     * @return
     */
    @Override
    public Response<DetailedTaskResponse> handleCommand(CreateTaskCommand command) {
        var user = uow.getUserRepository().findById(command.getUserID());
        if(user == null) {
            return Response.<DetailedTaskResponse>ProduceNotFoundResult("user", Messages.NOT_FOUND);
        }
        var task = TaskMap.mapTask(command, user);
        uow.getTaskRepository().save(task);
        return Response.<DetailedTaskResponse>ProduceSuccessResult(TaskMap.mapDetailedTaskResponse(task));
    }
}
