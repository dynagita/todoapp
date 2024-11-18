package com.example.todoapp.api.Controllers;

import com.example.todoapp.Utils.Enums.ResponseStatus;
import com.example.todoapp.Utils.Mediator.Interfaces.IMediatorInitializer;
import com.example.todoapp.application.Responses.Response;
import com.example.todoapp.application.Responses.User.UserResponse;
import com.example.todoapp.application.Requests.Users.CreateUserCommand;
import com.example.todoapp.application.Requests.Users.GetUserByIdQuery;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Controller used for allow user's management
 */
@RestController
@RequestMapping("/api/users")
public class UserController extends ControllerBase{

    public UserController(@Autowired IMediatorInitializer mediator) {
        super(mediator);
    }

    /**
     * Method who allow new user creation
     * @param command user command
     * @return new UserCreated
     */
    @PostMapping
    public CompletableFuture<ResponseEntity<Response<UserResponse>>> addUser(@Valid @RequestBody CreateUserCommand command) {


        var response = (Response<UserResponse>) mediator.sendAsync(command).join();
        return CompletableFuture.supplyAsync(()-> ResponseEntity.<Response<UserResponse>>ok(response));
    }

    /**
     * Method who allow get created users
     * @param id
     * @return user searched for
     */

    @GetMapping("{id}")
    public CompletableFuture<ResponseEntity<Response<UserResponse>>> getUser(@PathVariable UUID id) {
        var response = (Response<UserResponse>) mediator.sendAsync(new GetUserByIdQuery(id)).join();
        if(response.getStatus() == ResponseStatus.NOT_FOUND)
            return CompletableFuture.supplyAsync(()-> new ResponseEntity<Response<UserResponse>>(response, HttpStatus.NOT_FOUND));
        return CompletableFuture.supplyAsync(()-> ResponseEntity.<Response<UserResponse>>ok(response));
    }
}
