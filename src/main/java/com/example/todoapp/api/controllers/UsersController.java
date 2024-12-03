package com.example.todoapp.api.controllers;

import com.example.todoapp.borders.requests.tasks.CreateTaskCommand;
import com.example.todoapp.borders.requests.tasks.GetTaskByIdQuery;
import com.example.todoapp.borders.requests.tasks.ListTasksByUserQuery;
import com.example.todoapp.borders.responses.tasks.DetailedTaskResponse;
import com.example.todoapp.borders.responses.tasks.TaskResponse;
import com.example.todoapp.borders.utils.mediator.interfaces.IMediator;
import com.example.todoapp.borders.responses.Response;
import com.example.todoapp.borders.requests.users.CreateUserCommand;
import com.example.todoapp.borders.requests.users.GetUserByIdQuery;
import com.example.todoapp.borders.utils.constants.Messages;
import com.example.todoapp.borders.responses.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
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
                    @ApiResponse(responseCode = "400", description = Messages.ERROR_REQUEST_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "409", description = Messages.ERROR_CONFLICT, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "422", description = Messages.ERROR_BUSINESS_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "500", description = Messages.INTERNAL_SERVER_ERROR, useReturnTypeSchema = true),
            })
    @PostMapping
    public CompletableFuture<ResponseEntity<Response<UserResponse>>> addUser(@Valid @RequestBody CreateUserCommand command) {
        return CompletableFuture.supplyAsync(()->{
            var response = (Response<UserResponse>) mediator.sendAsync(command).join();
            return ResponseEntity.<Response<UserResponse>>ok(response);
        });
    }

    /**
     * Method who allow get created users
     * @param id
     * @return user searched for
     */

    @Operation(summary = "Get user by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = Messages.SUCCESS_MESSAGE, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "400", description = Messages.ERROR_REQUEST_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "404", description = Messages.NOT_FOUND, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "500", description = Messages.INTERNAL_SERVER_ERROR, useReturnTypeSchema = true),
            })
    @GetMapping("{id}")
    public CompletableFuture<ResponseEntity<Response<UserResponse>>> getUser(@PathVariable UUID id) {
        return CompletableFuture.supplyAsync(()-> {
            var response = (Response<UserResponse>) mediator.sendAsync(new GetUserByIdQuery(id)).join();
            return ResponseEntity.ok(response);
        });
    }

    /**
     * Method who allow new task creation
     * @param request
     * @return
     */
    @Operation(summary = "Create a new task",
            responses = {
                    @ApiResponse(responseCode = "200", description = Messages.SUCCESS_MESSAGE, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "400", description = Messages.ERROR_REQUEST_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "404", description = Messages.NOT_FOUND, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "409", description = Messages.ERROR_CONFLICT, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "422", description = Messages.ERROR_BUSINESS_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "500", description = Messages.INTERNAL_SERVER_ERROR, useReturnTypeSchema = true),
            })
    @PostMapping("{id}/tasks")
    public CompletableFuture<ResponseEntity<Response<TaskResponse>>> addTask(@PathVariable UUID id, @Valid @RequestBody CreateTaskCommand request) {
        return CompletableFuture.supplyAsync(()->{
            request.setUserID(id);
            var response = (Response<TaskResponse>) mediator.sendAsync(request).join();
         return ResponseEntity.ok(response);
        });
    }

    /**
     * Method who allows list User's tasks
     * @param userid
     * @param skip
     * @param take
     * @return
     */
    @Operation(summary = "Get user's tasks. Default take: 25. Limit take: 100",
            responses = {
                    @ApiResponse(responseCode = "200", description = Messages.SUCCESS_MESSAGE, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "400", description = Messages.ERROR_REQUEST_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "500", description = Messages.INTERNAL_SERVER_ERROR, useReturnTypeSchema = true),
            })
    @GetMapping("{userid}/tasks")
    public CompletableFuture<ResponseEntity<Response<List<TaskResponse>>>> listTasks(@PathVariable UUID userid, @RequestParam int skip, @RequestParam int take) {
        return CompletableFuture.supplyAsync(() -> {
            var response = (Response<List<TaskResponse>>) mediator.sendAsync(new ListTasksByUserQuery(userid, skip, take)).join();
            return ResponseEntity.ok(response);
        });

    }

    @Operation(summary = "Get task by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = Messages.SUCCESS_MESSAGE, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "400", description = Messages.ERROR_REQUEST_VALIDATION, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "404", description = Messages.NOT_FOUND, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "500", description = Messages.INTERNAL_SERVER_ERROR, useReturnTypeSchema = true),
            })
    @GetMapping("{userid}/tasks/{taskid}")
    public CompletableFuture<ResponseEntity<Response<DetailedTaskResponse>>> getDetailedTask(@PathVariable UUID userid, @PathVariable UUID taskid){
        return CompletableFuture.supplyAsync(()->{
            Response<DetailedTaskResponse> response  = (Response<DetailedTaskResponse>) mediator.sendAsync(new GetTaskByIdQuery(userid, taskid)).join();
            return ResponseEntity.<Response<DetailedTaskResponse>>ok(response);
        }) ;
    }
}
