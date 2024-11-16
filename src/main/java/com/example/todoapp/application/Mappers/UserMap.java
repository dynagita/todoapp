package com.example.todoapp.application.Mappers;

import com.example.todoapp.application.Responses.User.UserResponse;
import com.example.todoapp.application.UseCases.User.CreateUser.CreateUserCommand;
import com.example.todoapp.domain.models.User;

public class UserMap {
    /**
     * Create a new User based on CreateUserCommand
     * @param user
     * @return user
     */
    public static User mapUser(CreateUserCommand user){
        return new User(
                user.getUsername(),
                user.getEmail(),
                user.getName(),
                user.getLastName(),
                user.getBornDate());
    }

    /**
     * Create a new User response based on User
     * @param user who you wish to return
     * @return user response
     */
    public static UserResponse mapUserResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getLastName(),
                user.getBornDate());
    }
}
