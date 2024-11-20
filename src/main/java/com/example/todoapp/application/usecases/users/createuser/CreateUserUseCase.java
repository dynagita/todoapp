package com.example.todoapp.application.usecases.users.createuser;

import com.example.todoapp.application.mappers.UserMap;
import com.example.todoapp.application.requests.users.CreateUserCommand;
import com.example.todoapp.application.responses.Response;
import com.example.todoapp.application.responses.user.UserResponse;
import com.example.todoapp.domain.repositories.IUserRepository;
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
