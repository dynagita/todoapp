package com.example.todoapp.application.usecases.users;

import com.example.todoapp.borders.mappers.UserMap;
import com.example.todoapp.borders.requests.users.CreateUserCommand;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.user.UserResponse;
import com.example.todoapp.borders.repositories.IUserRepository;
import com.example.todoapp.borders.usecases.users.ICreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.concurrent.CompletableFuture;

/**
 * Use case for processing user creation
 */
@Service
@Validated
public class CreateUserUseCase implements ICreateUserUseCase {

    private final IUserRepository userRepository;

    /**
     * Create a new CreateUserUseCase
     * @param userRepository
     */
    public CreateUserUseCase(@Autowired IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Handle user creation
     * @param command
     * @return
     */
    @Override
    public CompletableFuture<Response<UserResponse>> handle(CreateUserCommand command) {
        return CompletableFuture.supplyAsync(() -> {
            var user = UserMap.mapUser(command);

            user = userRepository.save(user);

            return Response.<UserResponse>ProduceSuccessResult(UserMap.mapUserResponse(user));
        });
    }
}
