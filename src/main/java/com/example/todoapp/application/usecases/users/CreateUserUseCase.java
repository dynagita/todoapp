package com.example.todoapp.application.usecases.users;

import com.example.todoapp.application.usecases.CommandHandlerBaseUseCase;
import com.example.todoapp.application.usecases.users.validators.NewUserValidator;
import com.example.todoapp.borders.mappers.UserMap;
import com.example.todoapp.borders.repositories.IUnityOfWork;
import com.example.todoapp.borders.requests.users.CreateUserCommand;
import com.example.todoapp.borders.responses.ErrorDetail;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.user.UserResponse;
import com.example.todoapp.borders.usecases.users.ICreateUserUseCase;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;

/**
 * Use case for processing user creation
 */
@Service
@Validated
public class CreateUserUseCase extends CommandHandlerBaseUseCase<CreateUserCommand, UserResponse> implements ICreateUserUseCase {

    private final IUnityOfWork uow;

    /**
     * Create a new CreateUserUseCase
     * @param uow
     */
    public CreateUserUseCase(IUnityOfWork uow) {
        this.uow = uow;
    }

    /**
     * Handle use case logic for execution
     * @param command
     * @return
     */
    @Override
    public Response<UserResponse> handleCommand(CreateUserCommand command) {

        var filter = new HashMap<String, Object>();
        filter.put("email", command.getEmail());

        var user = uow.getUserRepository().find(filter);

        var validator = new NewUserValidator();

        var validatorResult =validator.validate(user);
        if(!validatorResult.isValid()){
            return Response
                    .<UserResponse>ProduceConflitResult(validator
                                                                 .getErrorsDetail(validatorResult));
        }

        user = UserMap
                .mapUser(command);
        user = uow
                .getUserRepository()
                .save(user);
        return Response
                .<UserResponse>ProduceSuccessResult(UserMap
                                                    .mapUserResponse(user));
    }
}
