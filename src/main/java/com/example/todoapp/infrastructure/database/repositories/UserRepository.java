package com.example.todoapp.infrastructure.database.repositories;

import com.example.todoapp.domain.models.User;
import com.example.todoapp.domain.repositories.IUserRepository;

/**
 * User repository
 */
@org.springframework.stereotype.Repository
public class UserRepository extends Repository<User> implements IUserRepository {
    public UserRepository() {
        super(User.class);
    }
}
