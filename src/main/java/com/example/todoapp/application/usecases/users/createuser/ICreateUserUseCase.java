package com.example.todoapp.application.usecases.users.createuser;

import com.example.todoapp.utils.mediator.interfaces.commands.ICommandHandler;
import com.example.todoapp.application.requests.users.CreateUserCommand;
import com.example.todoapp.application.responses.Response;
import com.example.todoapp.application.responses.user.UserResponse;

public interface ICreateUserUseCase extends ICommandHandler<CreateUserCommand, Response<UserResponse>> {
}
