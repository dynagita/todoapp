package com.example.todoapp.application.UseCases.Users;

import com.example.todoapp.Utils.Mediator.Interfaces.Queries.IQuery;
import com.example.todoapp.Utils.Mediator.Interfaces.Queries.IQueryHandler;
import com.example.todoapp.application.Responses.Response;

import java.util.concurrent.CompletableFuture;

public abstract class QueryUseCase<Query extends IQuery, Result> implements IQueryHandler<Query, Response<Result>> {

    protected abstract CompletableFuture<Result> handleAction(Query query);

    @Override
    public CompletableFuture<Response<Result>> handle(Query query) {
        try {
            var response = handleAction(query).join();
            return CompletableFuture.supplyAsync(() ->  Response.<Result>ProduceSuccessResult(response));
        }
        catch(Exception ex){
            return CompletableFuture.supplyAsync(() ->{
                return Response.<Result>ProduceInternalServerErrorResult();
            });
        }
    }
}
