package com.example.todoapp.application.UseCases.User.GetUserById;

import com.example.todoapp.Utils.Mediator.Interfaces.Queries.IQueryHandler;
import com.example.todoapp.application.Responses.Response;
import com.example.todoapp.application.Responses.User.UserResponse;

public interface IGetUserByIdUseCase extends IQueryHandler<GetUserByIdQuery, Response<UserResponse>> {
}
