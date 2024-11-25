package com.example.todoapp.application.usecases;

import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.utils.mediator.interfaces.commands.ICommand;
import com.example.todoapp.borders.utils.mediator.interfaces.commands.ICommandHandler;

import java.util.concurrent.CompletableFuture;

/**
 * Abstract class created for abstracting Commands implementations, helping user threat exceptions generically
 * @param <Command> Command data who will be processed
 * @param <Result> Command handler response
 */
public abstract class CommandHandlerBaseUseCase<Command extends ICommand, Result> implements ICommandHandler<Command, Response<Result>> {
    /**
     * Abstract method for users implement use case logic
     * @param command
     * @return
     */
    public abstract Response<Result> handleCommand(Command command);

    /**
     * Handle Commands use case, directing executions
     * @param command data for being processed
     * @return
     */
    @Override
    public CompletableFuture<Response<Result>> handle(Command command) {
        return CompletableFuture.supplyAsync(() -> {
            try{
                return handleCommand(command);
            }
            catch (Exception ex){
                return Response.ProduceInternalServerErrorResult();
            }
        });
    }
}
