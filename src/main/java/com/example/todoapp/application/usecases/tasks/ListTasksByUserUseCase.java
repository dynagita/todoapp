package com.example.todoapp.application.usecases.tasks;

import com.example.todoapp.application.usecases.QueryHandlerBaseUseCase;
import com.example.todoapp.borders.mappers.TaskMap;
import com.example.todoapp.borders.repositories.IUnityOfWork;
import com.example.todoapp.borders.requests.tasks.ListTasksByUserQuery;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.tasks.TaskResponse;
import com.example.todoapp.borders.usecases.tasks.IListTasksByUserUseCase;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

/**
 * Use case for query user's tasks
 */
@Service
public class ListTasksByUserUseCase extends QueryHandlerBaseUseCase<ListTasksByUserQuery, List<TaskResponse>> implements IListTasksByUserUseCase {

    private final IUnityOfWork uow;

    /**
     * Create a new ListTasksUserUseCase
     * @param uow
     */
    public ListTasksByUserUseCase(IUnityOfWork uow) {
        this.uow = uow;
    }


    /**
     * Handle use case logic
     * @param query
     * @return
     */
    @Override
    public Response<List<TaskResponse>> handleQuery(ListTasksByUserQuery query) {
        var user = uow.getUserRepository().findById(query.getUserId());
        if(user == null) {
            return Response.<List<TaskResponse>>ProduceNotFoundResult("user", query.getUserId().toString());
        }

        var filter = new HashMap<String, Object>();
        filter.put("user", user);

        var result = uow.getTaskRepository().search(filter, query.getSkip(), query.getTake());

        return Response.<List<TaskResponse>>ProduceSuccessResult(TaskMap.mapTaskResponse(result));
    }
}
