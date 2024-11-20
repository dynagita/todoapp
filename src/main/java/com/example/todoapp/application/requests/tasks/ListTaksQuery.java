package com.example.todoapp.application.requests.tasks;

import com.example.todoapp.utils.mediator.interfaces.queries.IQuery;

import java.util.UUID;

/**
 * Query for searching tasks
 */
public class ListTaksQuery implements IQuery {
    private UUID id;

    /**
     * Create a new ListTaksQuery
     */
    public ListTaksQuery(){}

    /**
     * Create a new ListTaksQuery
     * @param id
     */
    public ListTaksQuery(UUID id) {
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
