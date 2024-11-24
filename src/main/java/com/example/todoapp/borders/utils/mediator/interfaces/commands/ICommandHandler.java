package com.example.todoapp.borders.utils.mediator.interfaces.commands;

import java.util.concurrent.CompletableFuture;

public interface ICommandHandler<Command extends ICommand, Result> {
    CompletableFuture<Result> handle(Command query);
}
