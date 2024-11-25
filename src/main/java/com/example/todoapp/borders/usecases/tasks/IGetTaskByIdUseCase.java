package com.example.todoapp.borders.usecases.tasks;

import com.example.todoapp.borders.requests.tasks.GetTaskByIdQuery;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.tasks.DetailedTaskResponse;
import com.example.todoapp.borders.utils.mediator.interfaces.queries.IQueryHandler;

public interface IGetTaskByIdUseCase extends IQueryHandler<GetTaskByIdQuery, Response<DetailedTaskResponse>> {
}
