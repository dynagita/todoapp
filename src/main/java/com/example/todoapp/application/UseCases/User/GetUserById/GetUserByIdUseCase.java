package com.example.todoapp.application.UseCases.User.GetUserById;

import com.example.todoapp.application.Mappers.UserMap;
import com.example.todoapp.application.Responses.Response;
import com.example.todoapp.application.Responses.User.UserResponse;
import com.example.todoapp.domain.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class GetUserByIdUseCase implements IGetUserByIdUseCase {

    private final IUserRepository userRepository;

    public GetUserByIdUseCase(@Autowired IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CompletableFuture<Response<UserResponse>> handle(GetUserByIdQuery query) {
        return CompletableFuture.supplyAsync(()->{
            var user = userRepository.findById(query.getId());
            return Response.<UserResponse>ProduceSuccessResult(UserMap.mapUserResponse(user));
        });
    }
}
