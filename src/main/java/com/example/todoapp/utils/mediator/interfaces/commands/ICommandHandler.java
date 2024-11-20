package com.example.todoapp.utils.mediator.interfaces.commands;

import java.util.concurrent.CompletableFuture;

public interface ICommandHandler<Command extends ICommand, Result> {
    CompletableFuture<Result> handle(Command query);
}
