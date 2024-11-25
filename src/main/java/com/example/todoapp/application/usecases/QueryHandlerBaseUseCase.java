package com.example.todoapp.application.usecases;

import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.utils.mediator.interfaces.queries.IQuery;
import com.example.todoapp.borders.utils.mediator.interfaces.queries.IQueryHandler;

import java.util.concurrent.CompletableFuture;

/**
 * Abstract class created for abstracting Commands implementations, helping user threat exceptions generically
 * @param <Query> Query data who will be processed
 * @param <Result> Query handler response
 */
public abstract class QueryHandlerBaseUseCase<Query extends IQuery, Result> implements IQueryHandler<Query, Response<Result>> {

    /**
     * Abstract method for users implement use case logic
     * @param query
     * @return
     */
    public abstract Response<Result> handleQuery(Query query);

    /**
     * Handle Query use case, directing executions
     * @param query data for being processed
     * @return
     */
    @Override
    public CompletableFuture<Response<Result>> handle(Query query){
        return CompletableFuture.supplyAsync(()->{
            try{
                return handleQuery(query);
            }catch (Exception ex){
                return Response.ProduceInternalServerErrorResult();
            }
        });
    }
}
