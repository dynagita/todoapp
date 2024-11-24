package com.example.todoapp.borders.usecases.users;

import com.example.todoapp.borders.utils.mediator.interfaces.queries.IQueryHandler;
import com.example.todoapp.borders.requests.users.GetUserByIdQuery;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.user.UserResponse;

public interface IGetUserByIdUseCase extends IQueryHandler<GetUserByIdQuery, Response<UserResponse>> {
}
