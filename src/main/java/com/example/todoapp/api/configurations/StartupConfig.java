package com.example.todoapp.api.configurations;

import com.example.todoapp.utils.mediator.impl.Mediator;
import com.example.todoapp.utils.mediator.impl.MediatorRegister;
import com.example.todoapp.application.requests.users.CreateUserCommand;
import com.example.todoapp.application.usecases.users.createuser.ICreateUserUseCase;
import com.example.todoapp.application.requests.users.GetUserByIdQuery;
import com.example.todoapp.application.usecases.users.getuserbyid.IGetUserByIdUseCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StartupConfig {

    @Bean
    public CommandLineRunner onStartup() {
        return args -> {
            List<MediatorRegister> registers = new ArrayList<>();

            //Add registers here
            registers.add(new MediatorRegister(CreateUserCommand.class, ICreateUserUseCase.class));
            registers.add(new MediatorRegister(GetUserByIdQuery.class, IGetUserByIdUseCase.class));
            registers.forEach(register ->{
                Mediator.registerHandler(register);
            });
        };
    }
}
