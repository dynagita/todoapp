package com.example.todoapp.borders.requests.tasks;

import com.example.todoapp.borders.utils.mediator.interfaces.queries.IQuery;

import java.util.UUID;

/**
 * Query for searching a task by ID
 */
public class GetTaskByIdQuery implements IQuery {
    private UUID userId;
    private UUID taskId;

    /**
     * Create new GetTaskByIdQuery
     */
    public GetTaskByIdQuery() {
    }

    /**
     * Create new GetTaskByIdQuery
     */
    public GetTaskByIdQuery(UUID userId, UUID taskId) {
        this.userId = userId;
        this.taskId = taskId;
    }

    /**
     * Get user id
     * @return
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Get task id
     * @return
     */
    public UUID getTaskId() {
        return taskId;
    }
}
