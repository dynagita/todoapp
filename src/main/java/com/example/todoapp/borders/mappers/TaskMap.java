package com.example.todoapp.borders.mappers;

import com.example.todoapp.borders.models.Task;
import com.example.todoapp.borders.models.User;
import com.example.todoapp.borders.requests.tasks.CreateTaskCommand;
import com.example.todoapp.borders.responses.tasks.DetailedTaskResponse;
import com.example.todoapp.borders.responses.tasks.TaskResponse;

import java.util.ArrayList;
import java.util.List;

public class TaskMap {
    /**
     * Map a task to task response
     * @param task
     * @return
     */
    public static TaskResponse mapTaskResponse(Task task) {
        return new TaskResponse(task);
    }

    /**
     * Map a list of tasks to tasks responses
     * @param tasks
     * @return
     */
    public static List<TaskResponse> mapTaskResponse(List<Task> tasks){
        List<TaskResponse> taskResponses = new ArrayList<TaskResponse>();

        tasks.forEach(task -> taskResponses.add(mapTaskResponse(task)));

        return taskResponses;
    }

    /**
     * Map a detailed task response
     * @param task
     * @return
     */
    public static DetailedTaskResponse mapDetailedTaskResponse(Task task) {
        return new DetailedTaskResponse(task);
    }

    public static Task mapTask(CreateTaskCommand task, User user){
        return new Task();
    }
}
