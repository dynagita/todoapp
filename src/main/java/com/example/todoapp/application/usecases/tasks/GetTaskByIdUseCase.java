package com.example.todoapp.application.usecases.tasks;

import com.example.todoapp.application.usecases.QueryHandlerBaseUseCase;
import com.example.todoapp.borders.mappers.TaskMap;
import com.example.todoapp.borders.repositories.IUnityOfWork;
import com.example.todoapp.borders.requests.tasks.GetTaskByIdQuery;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.tasks.DetailedTaskResponse;
import com.example.todoapp.borders.usecases.tasks.IGetTaskByIdUseCase;
import org.springframework.stereotype.Service;

/**
 * Use case for retriving a detailed task
 */
@Service
public class GetTaskByIdUseCase extends QueryHandlerBaseUseCase<GetTaskByIdQuery, DetailedTaskResponse> implements IGetTaskByIdUseCase {

    private final IUnityOfWork uow;

    /**
     * Create a new GetTaskByIdUseCase
     * @param uow
     */
    public GetTaskByIdUseCase(IUnityOfWork uow) {
        this.uow = uow;
    }

    /**
     * Handle use case logic
     * @param query
     * @return
     */
    @Override
    public Response<DetailedTaskResponse> handleQuery(GetTaskByIdQuery query) {
        var result = uow.getTaskRepository().findById(query.getTaskId());
        if (result == null) {
            return Response.<DetailedTaskResponse>ProduceNotFoundResult("id", query.getUserId().toString());
        }
        return Response.<DetailedTaskResponse>ProduceSuccessResult(TaskMap.mapDetailedTaskResponse(result));
    }
}
