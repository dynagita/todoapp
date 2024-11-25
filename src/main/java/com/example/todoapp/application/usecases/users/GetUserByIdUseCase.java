package com.example.todoapp.application.usecases.users;

import com.example.todoapp.application.usecases.QueryHandlerBaseUseCase;
import com.example.todoapp.borders.mappers.UserMap;
import com.example.todoapp.borders.repositories.IUnityOfWork;
import com.example.todoapp.borders.requests.users.GetUserByIdQuery;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.responses.user.UserResponse;
import com.example.todoapp.borders.usecases.users.IGetUserByIdUseCase;
import org.springframework.stereotype.Service;

/**
 * Query for retrieving user by id
 */
@Service
public class GetUserByIdUseCase extends QueryHandlerBaseUseCase<GetUserByIdQuery, UserResponse> implements IGetUserByIdUseCase {

    private final IUnityOfWork uow;

    /**
     * Create a new GetUserByIdUseCase
     * @param uow
     */
    public GetUserByIdUseCase(IUnityOfWork uow) {

        this.uow = uow;
    }

    /**
     * Handle query for logic execution
     * @param query
     * @return
     */
    @Override
    public Response<UserResponse> handleQuery(GetUserByIdQuery query) {
        var user = uow.getUserRepository().findById(query.getId());
        if(user == null)
            return Response.<UserResponse>ProduceNotFoundResult("id", query.getId().toString());
        return Response.<UserResponse>ProduceSuccessResult(UserMap.mapUserResponse(user));
    }
}
