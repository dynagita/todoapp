package com.example.todoapp.application.UseCases.Users;

import com.example.todoapp.Utils.Mediator.Interfaces.Commands.ICommand;
import com.example.todoapp.Utils.Mediator.Interfaces.Commands.ICommandHandler;
import com.example.todoapp.application.Responses.Response;

import java.util.concurrent.CompletableFuture;

public abstract class CommandUseCase<Command extends ICommand, Result> implements ICommandHandler<Command, Response<Result>> {

    protected abstract CompletableFuture<Response<Result>> handleAction(Command command);

    @Override
    public CompletableFuture<Response<Result>> handle(Command command) {
        try {
            return handleAction(command);
        }
        catch(Exception ex){
            return CompletableFuture.supplyAsync(() ->{
                return Response.<Result>ProduceInternalServerErrorResult();
            });
        }
    }
}
