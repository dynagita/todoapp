package com.example.todoapp.application.UseCases.Users.GetUserById;

import com.example.todoapp.Utils.Mediator.Interfaces.Queries.IQuery;

import java.util.UUID;

public class GetUserByIdQuery implements IQuery {
    private UUID id;

    public GetUserByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
