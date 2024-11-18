package com.example.todoapp.api.Controllers.Configurations;

import com.example.todoapp.Utils.Mediator.Interfaces.IMediator;
import com.example.todoapp.Utils.Mediator.impl.MediatorInitializer;
import com.example.todoapp.Utils.Mediator.impl.MediatorRegister;
import com.example.todoapp.application.Requests.Users.CreateUserCommand;
import com.example.todoapp.application.UseCases.Users.CreateUser.ICreateUserUseCase;
import com.example.todoapp.application.Requests.Users.GetUserByIdQuery;
import com.example.todoapp.application.UseCases.Users.GetUserById.IGetUserByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for helping organize mediator registers and get mediator registered
 * Throught this class registers will be done only on start application, next injections initialize will not run
 * cuz Mediator service is setted as Singleton
 */
@Service
public class MediatorLocator extends MediatorInitializer  {

    public MediatorLocator(
            @Autowired IMediator mediator) {
        this.mediator = mediator;
        initialize();
    }
    @Override
    public void initialize() {
        if(mediator.shouldRegister()){
            List<MediatorRegister> registers = new ArrayList<>();

            //Add registers here
            registers.add(new MediatorRegister(CreateUserCommand.class, ICreateUserUseCase.class));
            registers.add(new MediatorRegister(GetUserByIdQuery.class, IGetUserByIdUseCase.class));
            registers.forEach(register ->{
                mediator.registerHandler(
                        register.getType(),
                        register.getHandler()
                );
            });
        }

    }
}
