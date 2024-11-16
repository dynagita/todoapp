package com.example.todoapp.api.controllers;

import com.example.todoapp.Utils.Mediator.Interfaces.IMediatorInitializer;
import com.example.todoapp.application.Responses.Response;
import com.example.todoapp.application.Responses.User.UserResponse;
import com.example.todoapp.application.UseCases.User.CreateUser.CreateUserCommand;
import com.example.todoapp.application.UseCases.User.GetUserById.GetUserByIdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Controller used for allow user's management
 */
@RestController
@RequestMapping("/users")
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
    public CompletableFuture<ResponseEntity<Response<UserResponse>>> addUser(@RequestBody CreateUserCommand command) {


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
        return CompletableFuture.supplyAsync(()-> ResponseEntity.<Response<UserResponse>>ok(response));
    }
}
