package com.example.todoapp.borders.requests.tasks;

import com.example.todoapp.borders.utils.mediator.interfaces.queries.IQuery;

import java.util.UUID;

/**
 * Query for searching a task by ID
 */
public class GetTaskByIdQuery implements IQuery {
    private UUID id;

    /**
     * Create new GetTaskByIdQuery
     */
    public GetTaskByIdQuery() {
    }

    /**
     * Create new GetTaskByIdQuery
     */
    public GetTaskByIdQuery(UUID id) {
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
