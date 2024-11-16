package com.example.todoapp.Utils.Mediator.impl;

import com.example.todoapp.Utils.Mediator.Interfaces.IMediator;
import com.example.todoapp.Utils.Mediator.Interfaces.IMediatorInitializer;

public abstract class MediatorInitializer implements IMediatorInitializer {

    protected IMediator mediator;
    protected IMediatorInitializer mediatorInitialize;

    @Override
    public abstract void initialize();

    public IMediator getMediator() {
        return mediator;
    }
}
