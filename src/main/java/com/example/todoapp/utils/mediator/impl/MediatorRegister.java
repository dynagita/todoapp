package com.example.todoapp.utils.mediator.impl;

/**
 * Class who represents Mediator register
 */
public class MediatorRegister {
    private Class<?> commandQueryType;
    private Class<?> handlerType;

    /**
     * Create a new mediator register
     * @param commandQueryType the type of ICommand or IQuery who you wants to register
     * @param handlerType Command or Query handler type who you whant to assosciate to be triggered by the commandQueryType
     */
    public MediatorRegister(Class<?> commandQueryType, Class<?> handlerType) {
        this.commandQueryType = commandQueryType;
        this.handlerType = handlerType;
    }

    /**
     *
     * @return
     */
    public Class<?> getcommandQueryType() {
        return commandQueryType;
    }

    /**
     * Get handler type
     * @return
     */
    public Class<?> gethandlerType() {
        return handlerType;
    }
}
