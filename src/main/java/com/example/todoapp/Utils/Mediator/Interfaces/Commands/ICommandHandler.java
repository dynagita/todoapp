package com.example.todoapp.Utils.Mediator.Interfaces.Commands;

import java.util.concurrent.CompletableFuture;

public interface ICommandHandler<Command extends ICommand, Result> {
    CompletableFuture<Result> handle(Command query);
}
