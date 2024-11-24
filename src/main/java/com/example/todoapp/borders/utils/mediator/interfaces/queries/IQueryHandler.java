package com.example.todoapp.borders.utils.mediator.interfaces.queries;

import java.util.concurrent.CompletableFuture;

public interface IQueryHandler<Query extends IQuery, Result> {
    CompletableFuture<Result> handle(Query query);
}
