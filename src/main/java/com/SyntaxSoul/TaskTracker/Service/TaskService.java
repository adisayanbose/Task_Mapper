package com.SyntaxSoul.TaskTracker.Service;

import com.SyntaxSoul.TaskTracker.Models.Task;
import com.SyntaxSoul.TaskTracker.Models.TaskList;
import com.SyntaxSoul.TaskTracker.Repository.TaskListRepository;
import com.SyntaxSoul.TaskTracker.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskListRepository taskListRepository;

    public  List<Task> GetTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    public Task putTasks(UUID taskListId, @RequestBody Task task) {
        System.out.println("in service");
        TaskList taskList=taskListRepository.findById(taskListId).get();
        task.setTaskList(taskList);
        return taskRepository.save(task);
    }


    public Task GetTask(UUID taskId, UUID taskListId) {
        return taskRepository.findByIdAndTaskListId(taskId,taskListId);
    }

    public Task UpdateTask(UUID taskId, UUID task_list_id, Task task) {
        TaskList taskList=taskListRepository.findById(task_list_id).get();
        task.setTaskList(taskList);
        task.setId(taskId);
        return taskRepository.save(task);
    }

    public Task deleteTask(UUID taskId) {
        Task task=taskRepository.findById(taskId).get();
        taskRepository.deleteById(taskId);
        return  task;
    }
}
