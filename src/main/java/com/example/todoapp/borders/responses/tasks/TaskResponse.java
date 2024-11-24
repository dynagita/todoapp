package com.example.todoapp.borders.responses.tasks;
import com.example.todoapp.borders.models.Task;
import com.example.todoapp.borders.utils.enums.TaskStatus;
import com.example.todoapp.borders.utils.constants.Limitations;

/**
 * Task response object
 */
public class TaskResponse {
    private String title;
    private String description;
    private TaskStatus status;

    /**
     * Create a new task response
     * @param title
     * @param description
     * @param status
     */
    public TaskResponse(String title, String description, TaskStatus status) {
        this.title = title;
        this.description = String.format("%s...", description.substring(0, Limitations.TASK_SUMMARY_LIMIT));;
        this.status = status;
    }

    /**
     * Create a new task response
     * @param task
     */
    public TaskResponse(Task task){
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
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
}
