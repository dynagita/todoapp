package com.example.todoapp.Utils.Mediator.impl;

public class MediatorRegister {
    private Class<?> type;
    private Class<?> handler;

    public MediatorRegister(Class<?> type, Class<?> handler) {
        this.type = type;
        this.handler = handler;
    }

    public Class<?> getType() {
        return type;
    }

    public Class<?> getHandler() {
        return handler;
    }
}
