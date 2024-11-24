package com.example.todoapp.borders.requests.tasks;

import com.example.todoapp.borders.utils.constants.Limitations;
import com.example.todoapp.borders.utils.constants.Messages;
import com.example.todoapp.borders.utils.mediator.interfaces.queries.IQuery;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/**
 * Query for searching tasks
 */
public class ListTasksByUserQuery implements IQuery {
    @NotNull(message = Messages.REQUIRED_PROPERTY)
    private UUID userId;
    @Min(value = Limitations.MIN_TAKE, message = Messages.MIN_TAKE_LIMIT)
    private int skip;
    @Max(value = Limitations.MAX_TAKE, message = Messages.MAX_TAKE_LIMIT)
    @Min(value = Limitations.MIN_TAKE, message = Messages.MIN_TAKE_LIMIT)
    private int take;

    /**
     * Create a new ListTaksQuery
     */
    public ListTasksByUserQuery(){}

    /**
     * Create a new ListTaksQuery
     * @param userId
     */
    public ListTasksByUserQuery(UUID userId, int skip, int take) {
        this.userId = userId;
        this.skip = skip;
        this.take = take == Limitations.MIN_TAKE ? Limitations.DEFAULT_TAKE : take;
    }

    /**
     * Get id
     * @return
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Get skip
     * @return
     */
    public int getSkip() {
        return skip;
    }

    /**
     * Get take
     * @return
     */
    public int getTake() {
        return take;
    }

    public void setUserId(@NotNull(message = Messages.REQUIRED_PROPERTY) UUID userId) {
        this.userId = userId;
    }

    public void setSkip(@Min(value = Limitations.MIN_TAKE, message = Messages.MIN_TAKE_LIMIT) int skip) {
        this.skip = skip;
    }

    public void setTake(@Max(value = Limitations.MAX_TAKE, message = Messages.MAX_TAKE_LIMIT) @Min(value = Limitations.MIN_TAKE, message = Messages.MIN_TAKE_LIMIT) int take) {
        this.take = take;
    }
}
