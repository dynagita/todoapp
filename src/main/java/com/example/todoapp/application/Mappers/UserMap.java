package com.example.todoapp.application.Mappers;

import com.example.todoapp.application.Responses.User.UserResponse;
import com.example.todoapp.application.UseCases.Users.CreateUser.CreateUserCommand;
import com.example.todoapp.domain.models.User;

public class UserMap {
    /**
     * Create a new User based on CreateUserCommand
     * @param user
     * @return user
     */
    public static User mapUser(CreateUserCommand user){
        return new User(
                user.getEmail(),
                user.getName(),
                user.getLastName(),
                user.getBornDate(),
                user.getPhoneNumber()
                );
        //String email, String name, String lastName, Date bornDate, String phoneNumber
    }

    /**
     * Create a new User response based on User
     * @param user who you wish to return
     * @return user response
     */
    public static UserResponse mapUserResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getLastName(),
                user.getBornDate(),
                user.getPhoneNumber()
        );
    }
}
