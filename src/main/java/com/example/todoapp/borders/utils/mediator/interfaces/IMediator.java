package com.example.todoapp.borders.utils.mediator.interfaces;

import com.example.todoapp.borders.utils.mediator.interfaces.commands.ICommand;
import com.example.todoapp.borders.utils.mediator.interfaces.queries.IQuery;

import java.util.concurrent.CompletableFuture;

public interface IMediator {
    <Query extends IQuery, Result> CompletableFuture<Result> sendAsync(Query query);
    <Command extends ICommand, Result> CompletableFuture<Result> sendAsync(Command command);
}