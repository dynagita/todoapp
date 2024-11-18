package com.example.todoapp.application.UseCases.Users.CreateUser;

import com.example.todoapp.application.Mappers.UserMap;
import com.example.todoapp.application.Requests.Users.CreateUserCommand;
import com.example.todoapp.application.Responses.Response;
import com.example.todoapp.application.Responses.User.UserResponse;
import com.example.todoapp.domain.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.concurrent.CompletableFuture;

@Service
@Validated
public class CreateUserUseCase implements ICreateUserUseCase {

    private final IUserRepository userRepository;

    public CreateUserUseCase(@Autowired IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CompletableFuture<Response<UserResponse>> handle(CreateUserCommand command) {
        return CompletableFuture.supplyAsync(() -> {
            var user = UserMap.mapUser(command);

            user = userRepository.save(user);

            return Response.<UserResponse>ProduceSuccessResult(UserMap.mapUserResponse(user));
        });
    }
}
