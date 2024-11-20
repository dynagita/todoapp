package com.example.todoapp.api.controllers;

import com.example.todoapp.application.requests.tasks.CreateTaskCommand;
import com.example.todoapp.application.requests.tasks.ListTaksQuery;
import com.example.todoapp.application.responses.tasks.TaskResponse;
import com.example.todoapp.utils.mediator.interfaces.IMediator;
import com.example.todoapp.application.responses.Response;
import com.example.todoapp.application.requests.users.CreateUserCommand;
import com.example.todoapp.application.requests.users.GetUserByIdQuery;
import com.example.todoapp.utils.constants.Messages;
import com.example.todoapp.application.responses.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jdk.jfr.ContentType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Controller used for allow user's management
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final IMediator mediator;

    public UsersController(IMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Method who allow new user creation
     * @param command user command
     * @return new UserCreated
     */
    @Operation(summary = "Create a new user",
            responses = {
                    @ApiResponse(responseCode = "200", description = Messages.SUCCESS_MESSAGE, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "422", description = Messages.ERROR_BUSINESS_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "500", description = Messages.INTERNAL_SERVER_ERROR, useReturnTypeSchema = true),
            })
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

    @Operation(summary = "Get user by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = Messages.SUCCESS_MESSAGE, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "400", description = Messages.NOT_FOUND, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "422", description = Messages.ERROR_BUSINESS_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "500", description = Messages.INTERNAL_SERVER_ERROR, useReturnTypeSchema = true),
            })
    @GetMapping("{id}")
    public CompletableFuture<ResponseEntity<Response<UserResponse>>> getUser(@PathVariable UUID id) {
        var response = (Response<UserResponse>) mediator.sendAsync(new GetUserByIdQuery(id)).join();
        return CompletableFuture.supplyAsync(()-> ResponseEntity.ok(response));
    }

    /**
     * Method who allow new task creation
     * @param request
     * @return
     */
    @Operation(summary = "Create a new task",
            responses = {
                    @ApiResponse(responseCode = "200", description = Messages.SUCCESS_MESSAGE, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "422", description = Messages.ERROR_BUSINESS_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "500", description = Messages.INTERNAL_SERVER_ERROR, useReturnTypeSchema = true),
            })
    @PostMapping("{id}/tasks")
    public CompletableFuture<ResponseEntity<Response<TaskResponse>>> addTask(@PathVariable UUID id, @Valid @RequestBody CreateTaskCommand request) {

        request.setUserID(id);

        var response = (Response<TaskResponse>) mediator.sendAsync(request).join();
        return CompletableFuture.supplyAsync(()-> ResponseEntity.ok(response));
    }

    /**
     * Method who allows list User's tasks
     * @param id
     * @return
     */
    @Operation(summary = "Get user's tasks",
            responses = {
                    @ApiResponse(responseCode = "200", description = Messages.SUCCESS_MESSAGE, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "422", description = Messages.ERROR_BUSINESS_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "500", description = Messages.INTERNAL_SERVER_ERROR, useReturnTypeSchema = true),
            })
    @GetMapping("{id}/tasks")
    public CompletableFuture<ResponseEntity<Response<List<TaskResponse>>>> listTasks(@PathVariable UUID id) {

        var response = (Response<List<TaskResponse>>) mediator.sendAsync(new ListTaksQuery(id)).join();
        return CompletableFuture.supplyAsync(()-> ResponseEntity.ok(response));
    }
}
