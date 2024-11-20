package com.example.todoapp.application.requests.users;

import com.example.todoapp.utils.mediator.interfaces.queries.IQuery;

import java.util.UUID;

/**
 * Query used for retriving a registered user
 */
public class GetUserByIdQuery implements IQuery {
    private UUID id;

    /**
     * Create a new GetUserByIdQuery
     * @param id
     */
    public GetUserByIdQuery(UUID id) {
        this.id = id;
    }

    /**
     * Get id
     * @return
     */
    public UUID getId() {
        return id;
    }
}
