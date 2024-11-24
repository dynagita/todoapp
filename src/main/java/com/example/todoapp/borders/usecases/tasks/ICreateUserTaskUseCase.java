package com.example.todoapp.borders.usecases.tasks;

import com.example.todoapp.borders.requests.tasks.CreateTaskCommand;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.tasks.DetailedTaskResponse;
import com.example.todoapp.borders.utils.mediator.interfaces.commands.ICommandHandler;

public interface ICreateUserTaskUseCase extends ICommandHandler<CreateTaskCommand, Response<DetailedTaskResponse>> {
}
