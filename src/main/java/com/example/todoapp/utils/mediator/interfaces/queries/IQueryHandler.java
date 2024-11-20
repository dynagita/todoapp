package com.example.todoapp.utils.mediator.interfaces.queries;

import java.util.concurrent.CompletableFuture;

public interface IQueryHandler<Query extends IQuery, Result> {
    CompletableFuture<Result> handle(Query query);
}
