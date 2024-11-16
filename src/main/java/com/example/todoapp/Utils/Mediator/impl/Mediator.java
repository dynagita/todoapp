package com.example.todoapp.Utils.Mediator.impl;

import com.example.todoapp.Utils.Mediator.Interfaces.Commands.ICommand;
import com.example.todoapp.Utils.Mediator.Interfaces.Commands.ICommandHandler;
import com.example.todoapp.Utils.Mediator.Interfaces.IMediator;
import com.example.todoapp.Utils.Mediator.Interfaces.Queries.IQuery;
import com.example.todoapp.Utils.Mediator.Interfaces.Queries.IQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Mediator implements IMediator {
    private Map<Class<?>, Class<?>> handlers = new HashMap<>();
    @Autowired
    private ApplicationContext applicationContext;

    public Mediator registerHandler(Class<?> type, Class<?> handler) {
        handlers.put(type, handler);
        return this;
    }

    @Override
    public boolean shouldRegister() {
        return handlers.isEmpty();
    }

    @Override
    public <Query extends IQuery, Result> CompletableFuture<Result> sendAsync(Query query) throws IllegalArgumentException{

        Class<?> handlerType = handlers.get(query.getClass());
        var handler = (IQueryHandler<Query, Result>) applicationContext.getBean(handlerType);
        if (handler != null) {
            return handler.handle(query);
        } else {
            throw new IllegalArgumentException("It was not found a QueryHandler for IQuery: " + query.getClass());
        }
    }

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
