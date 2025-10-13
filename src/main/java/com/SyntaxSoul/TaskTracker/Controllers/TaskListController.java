package com.SyntaxSoul.TaskTracker.Controllers;

import com.SyntaxSoul.TaskTracker.Models.TaskList;
import com.SyntaxSoul.TaskTracker.Service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-list")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;


    @GetMapping(path = "")
    public List<TaskList> GetTaskList(){
        System.out.println("hi ");
        return taskListService.GetTaskLists();
    }

    @PostMapping(path ="")
    public TaskList AddTaskList(@RequestBody TaskList taskList)
    {
        return taskListService.AddTaskList(taskList);
    }

    @GetMapping(path = "/{Id}")
    public Optional<TaskList> GetTaskListById(@PathVariable UUID Id){
        return taskListService.GetTaskListById(Id);
    }

    @PutMapping("/{id}")
    public TaskList PostTaskListById(@PathVariable UUID id,@RequestBody TaskList taskList){
        return taskListService.PutTaskListById(id,taskList);
    }

    @DeleteMapping("/{id}")
    public String DeleteTaskList(@PathVariable UUID id){
        return taskListService.DeleteTaskListById(id);
    }

}
