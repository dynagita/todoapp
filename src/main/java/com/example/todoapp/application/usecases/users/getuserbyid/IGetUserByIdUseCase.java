package com.example.todoapp.application.usecases.users.getuserbyid;

import com.example.todoapp.utils.mediator.interfaces.queries.IQueryHandler;
import com.example.todoapp.application.requests.users.GetUserByIdQuery;
import com.example.todoapp.application.responses.Response;
import com.example.todoapp.application.responses.user.UserResponse;

public interface IGetUserByIdUseCase extends IQueryHandler<GetUserByIdQuery, Response<UserResponse>> {
}
