package com.example.todoapp.application.UseCases.Users.CreateUser;

import com.example.todoapp.Utils.Mediator.Interfaces.Commands.ICommandHandler;
import com.example.todoapp.application.Responses.Response;
import com.example.todoapp.application.Responses.User.UserResponse;

public interface ICreateUserUseCase extends ICommandHandler<CreateUserCommand, Response<UserResponse>> {
}
