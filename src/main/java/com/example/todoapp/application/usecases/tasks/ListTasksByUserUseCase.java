package com.example.todoapp.application.usecases.tasks;

import com.example.todoapp.borders.mappers.TaskMap;
import com.example.todoapp.borders.repositories.ITaskRepository;
import com.example.todoapp.borders.repositories.IUserRepository;
import com.example.todoapp.borders.requests.tasks.ListTasksByUserQuery;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.tasks.TaskResponse;
import com.example.todoapp.borders.usecases.tasks.IListTasksByUserUseCase;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ListTasksByUserUseCase implements IListTasksByUserUseCase {

    private final ITaskRepository taskRepository;
    private final IUserRepository userRepository;

    public ListTasksByUserUseCase(ITaskRepository repository, IUserRepository userRepository) {
        this.taskRepository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public CompletableFuture<Response<List<TaskResponse>>> handle(ListTasksByUserQuery query) {
        return CompletableFuture.supplyAsync(()->{
            var response = new Response<List<TaskResponse>>();

            var user = userRepository.findById(query.getUserId());
            if(user == null) {
                return Response.ProduceNotFoundResult("user", query.getUserId().toString());
            }

            var filter = new HashMap<String, Object>();
            filter.put("user", user);

            var result = taskRepository.search(filter, query.getSkip(), query.getTake());

            return Response.ProduceSuccessResult(TaskMap.mapTaskResponse(result));
        });
    }


}
