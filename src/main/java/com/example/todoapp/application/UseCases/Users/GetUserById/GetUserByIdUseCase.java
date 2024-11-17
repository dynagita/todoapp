package com.example.todoapp.application.UseCases.Users.GetUserById;

import com.example.todoapp.application.Mappers.UserMap;
import com.example.todoapp.application.Responses.User.UserResponse;
import com.example.todoapp.application.UseCases.Users.QueryUseCase;
import com.example.todoapp.domain.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class GetUserByIdUseCase extends QueryUseCase<GetUserByIdQuery, UserResponse> implements IGetUserByIdUseCase {

    private final IUserRepository userRepository;

    public GetUserByIdUseCase(@Autowired IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected CompletableFuture<UserResponse> handleAction(GetUserByIdQuery query) {
        return CompletableFuture.supplyAsync(()->{
            var user = userRepository.findById(query.getId());
            return UserMap.mapUserResponse(user);
        });
    }
}
