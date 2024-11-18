package com.example.todoapp.application.UseCases.Users.GetUserById;

import com.example.todoapp.Utils.Mediator.Interfaces.Queries.IQueryHandler;
import com.example.todoapp.application.Requests.Users.GetUserByIdQuery;
import com.example.todoapp.application.Responses.Response;
import com.example.todoapp.application.Responses.User.UserResponse;

import java.util.concurrent.CompletableFuture;

public interface IGetUserByIdUseCase extends IQueryHandler<GetUserByIdQuery, Response<UserResponse>> {
}
