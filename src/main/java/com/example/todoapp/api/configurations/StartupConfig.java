package com.example.todoapp.api.configurations;

import com.example.todoapp.application.usecases.tasks.CreateUserTaskUseCase;
import com.example.todoapp.borders.requests.tasks.CreateTaskCommand;
import com.example.todoapp.borders.requests.tasks.GetTaskByIdQuery;
import com.example.todoapp.borders.requests.tasks.ListTasksByUserQuery;
import com.example.todoapp.borders.usecases.tasks.IGetTaskByIdUseCase;
import com.example.todoapp.borders.usecases.tasks.IListTasksByUserUseCase;
import com.example.todoapp.borders.utils.mediator.impl.Mediator;
import com.example.todoapp.borders.utils.mediator.impl.MediatorRegister;
import com.example.todoapp.borders.requests.users.CreateUserCommand;
import com.example.todoapp.borders.usecases.users.ICreateUserUseCase;
import com.example.todoapp.borders.requests.users.GetUserByIdQuery;
import com.example.todoapp.borders.usecases.users.IGetUserByIdUseCase;
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
            registers.add(new MediatorRegister(ListTasksByUserQuery.class, IListTasksByUserUseCase.class));
            registers.add(new MediatorRegister(CreateTaskCommand.class, CreateUserTaskUseCase.class));
            registers.add(new MediatorRegister(GetTaskByIdQuery.class, IGetTaskByIdUseCase.class));
            registers.forEach(register ->{
                Mediator.registerHandler(register);
            });
        };
    }
}
