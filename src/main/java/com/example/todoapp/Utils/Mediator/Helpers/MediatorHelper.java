package com.example.todoapp.Utils.Mediator.Helpers;

import com.example.todoapp.Utils.Mediator.Interfaces.IMediator;
import com.example.todoapp.Utils.Mediator.impl.MediatorRegister;

import java.util.List;

public class MediatorHelper {
    public static void RegisterCommandsAndQueries(IMediator mediator, List<MediatorRegister> registers){
        registers
                .forEach(register -> {
                        mediator.registerHandler(
                                        register.getType(),
                                        register.getHandler());
                });
    }
}
