package com.example.todoapp.api.Controllers;

import com.example.todoapp.Utils.Mediator.Interfaces.IMediator;
import com.example.todoapp.Utils.Mediator.Interfaces.IMediatorInitializer;

public class ControllerBase {

    protected final IMediator mediator;

    public ControllerBase(IMediatorInitializer mediator) {
        mediator.initialize();
        this.mediator = mediator.getMediator();
    }
}
