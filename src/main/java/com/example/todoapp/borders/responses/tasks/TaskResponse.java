package com.example.todoapp.borders.responses.tasks;
import com.example.todoapp.borders.models.Task;
import com.example.todoapp.borders.utils.enums.TaskStatus;
import com.example.todoapp.borders.utils.constants.Limitations;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Task response object
 */
public class TaskResponse {
    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime expectedCloseDate;
    private LocalDateTime actualCloseDate;

    /**
     * Create a new task response
     * @param task
     */
    public TaskResponse(Task task){
        this.id = task.getId();
        this.title = task.getTitle();
        var description = task.getDescription();
        this.description = String.format("%s...", task.getDescription().substring(0, description.length() > Limitations.TASK_SUMMARY_LIMIT ? Limitations.TASK_SUMMARY_LIMIT : description.length()));
        this.status = task.getStatus();
        createdAt = task.getCreatedAt();
        this.actualCloseDate = task.getActualCloseDate();
        this.expectedCloseDate = task.getExpectedCloseDate();
    }

    /**
     * Get title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get status
     * @return
     */
    public TaskStatus getStatus() {
        return status;
    }

    /**
     * Get created at
     * @return
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Get expected close date
     * @return
     */
    public LocalDateTime getExpectedCloseDate() {
        return expectedCloseDate;
    }

    /**
     * Get actual close date
     * @return
     */
    public LocalDateTime getActualCloseDate() {
        return actualCloseDate;
    }

    /**
     * Get id
     * @return
     */
    public UUID getId() {
        return id;
    }
}
