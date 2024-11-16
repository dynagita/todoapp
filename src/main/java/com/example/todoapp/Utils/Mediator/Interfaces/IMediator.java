package com.example.todoapp.Utils.Mediator.Interfaces;

import com.example.todoapp.Utils.Mediator.Interfaces.Commands.ICommand;
import com.example.todoapp.Utils.Mediator.Interfaces.Queries.IQuery;
import com.example.todoapp.Utils.Mediator.impl.Mediator;

import java.util.concurrent.CompletableFuture;

public interface IMediator {
    <Query extends IQuery, Result> CompletableFuture<Result> sendAsync(Query query);
    <Command extends ICommand, Result> CompletableFuture<Result> sendAsync(Command command);

    IMediator registerHandler(Class<?> type, Class<?> handler);
    boolean shouldRegister();
}
