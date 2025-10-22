package com.SyntaxSoul.TaskTracker.Controllers;


import com.SyntaxSoul.TaskTracker.DTOs.TaskDto;
import com.SyntaxSoul.TaskTracker.Models.Task;
import com.SyntaxSoul.TaskTracker.Repository.TaskListRepository;
import com.SyntaxSoul.TaskTracker.Repository.TaskRepository;
import com.SyntaxSoul.TaskTracker.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists/{task_list_id}/tasks")
public class TaskController {


    @Autowired
    private  TaskService taskService;

    @GetMapping()
    public List<TaskDto> GetTasks(@PathVariable UUID task_list_id)
    {
        return taskService.GetTasks(task_list_id);
    }

    @PostMapping()
    public TaskDto PutTasks(@PathVariable UUID task_list_id,@RequestBody Task task)
    {
        return taskService.putTasks(task_list_id,task);
    }

    @GetMapping(path = "/{task_id}")
    public TaskDto GetTask(@PathVariable UUID task_id,@PathVariable UUID task_list_id)
    {
        return taskService.GetTask(task_id,task_list_id);
    }

    @PutMapping(path = "/{task_id}")
    public Task PutTask(@PathVariable UUID task_id,@PathVariable UUID task_list_id,@RequestBody Task task)
    {
        return taskService.UpdateTask(task_id,task_list_id,task);
    }

    @DeleteMapping(path = "/{task_id}")
    public Task DeleteTask(@PathVariable UUID task_id){
        return taskService.deleteTask(task_id);
    }
}
