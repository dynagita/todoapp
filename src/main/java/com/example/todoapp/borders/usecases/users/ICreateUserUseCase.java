package com.example.todoapp.borders.usecases.users;

import com.example.todoapp.borders.utils.mediator.interfaces.commands.ICommandHandler;
import com.example.todoapp.borders.requests.users.CreateUserCommand;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.user.UserResponse;

public interface ICreateUserUseCase extends ICommandHandler<CreateUserCommand, Response<UserResponse>> {
}
