package com.example.todoapp.application.usecases.users.getuserbyid;

import com.example.todoapp.application.mappers.UserMap;
import com.example.todoapp.application.requests.users.GetUserByIdQuery;
import com.example.todoapp.application.responses.Response;
import com.example.todoapp.application.responses.user.UserResponse;
import com.example.todoapp.domain.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Query for retrieving user by id
 */
@Service
public class GetUserByIdUseCase implements IGetUserByIdUseCase {

    private final IUserRepository userRepository;

    /**
     * Create a new GetUserByIdUseCase
     * @param userRepository
     */
    public GetUserByIdUseCase(@Autowired IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Handle use case search
     * @param query
     * @return
     */
    @Override
    public CompletableFuture<Response<UserResponse>> handle(GetUserByIdQuery query) {
        return CompletableFuture.supplyAsync(()->{
            var user = userRepository.findById(query.getId());
            if(user == null)
               return Response.ProduceNotFoundResult(query.getId());
            return Response.<UserResponse>ProduceSuccessResult(UserMap.mapUserResponse(user));
        });
    }
}
