package com.example.todoapp.borders.usecases.tasks;

import com.example.todoapp.borders.requests.tasks.ListTasksByUserQuery;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.tasks.TaskResponse;
import com.example.todoapp.borders.utils.mediator.interfaces.queries.IQueryHandler;

import java.util.List;

public interface IListTasksByUserUseCase extends IQueryHandler<ListTasksByUserQuery, Response<List<TaskResponse>>> {
}
