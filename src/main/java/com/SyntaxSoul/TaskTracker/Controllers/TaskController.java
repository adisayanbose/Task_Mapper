package com.SyntaxSoul.TaskTracker.Controllers;


import com.SyntaxSoul.TaskTracker.Models.Task;
import com.SyntaxSoul.TaskTracker.Repository.TaskListRepository;
import com.SyntaxSoul.TaskTracker.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/task-lists/{task_list_id}/tasks")
public class TaskController {


    @Autowired
    private TaskRepository taskRepository;
    private TaskListRepository taskListRepository;

    @GetMapping()
    public List<Task> GetTasks(@PathVariable UUID task_list_id)
    {
        return taskListRepository.findById(task_list_id).get().getTasks();
    }

}
