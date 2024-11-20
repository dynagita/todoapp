package com.example.todoapp.utils.mediator.impl;

import com.example.todoapp.utils.mediator.interfaces.commands.ICommand;
import com.example.todoapp.utils.mediator.interfaces.commands.ICommandHandler;
import com.example.todoapp.utils.mediator.interfaces.IMediator;
import com.example.todoapp.utils.mediator.interfaces.queries.IQuery;
import com.example.todoapp.utils.mediator.interfaces.queries.IQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Mediator class, used to execute correct command or query
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Mediator implements IMediator {

    private static Map<Class<?>, Class<?>> handlers = new HashMap<>();

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Register Associate ICommands and IQueries with it's handlers
     * @param register
     */
    public static void registerHandler(MediatorRegister register) {
        handlers.put(register.getcommandQueryType(), register.gethandlerType());
    }

    /**
     * send Query to be executed for it's respective handler
     * @param query Query you wish searching
     * @return
     * @param <Query> IQuery
     * @param <Result> Response type
     */
    @Override
    public <Query extends IQuery, Result> CompletableFuture<Result> sendAsync(Query query) {

        Class<?> handlerType = handlers.get(query.getClass());
        var handler = (IQueryHandler<Query, Result>) applicationContext.getBean(handlerType);
        if (handler != null) {
            return handler.handle(query);
        } else {
            throw new IllegalArgumentException("It was not found a QueryHandler for IQuery: " + query.getClass());
        }
    }

    /**
     * send Command to be executed for it's respective handler
     * @param command Command you wish executing
     * @return
     * @param <Command> ICommand
     * @param <Result> Response type
     */
    @Override
    public <Command extends ICommand, Result> CompletableFuture<Result> sendAsync(Command command) {

        Class<?> handlerType = handlers.get(command.getClass());
        var handler = (ICommandHandler<Command, Result>) applicationContext.getBean(handlerType);

        if (handler != null) {
            return handler.handle(command);
        } else {
            throw new IllegalArgumentException("It was not found a CommandHandler for ICommand: " + command.getClass());
        }
    }
}
