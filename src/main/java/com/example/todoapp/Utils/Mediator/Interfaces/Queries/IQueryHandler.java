package com.example.todoapp.Utils.Mediator.Interfaces.Queries;

import java.util.concurrent.CompletableFuture;

public interface IQueryHandler<Query extends IQuery, Result> {
    CompletableFuture<Result> handle(Query query);
}
