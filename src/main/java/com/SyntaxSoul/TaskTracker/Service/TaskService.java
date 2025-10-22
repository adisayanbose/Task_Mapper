package com.SyntaxSoul.TaskTracker.Service;

import com.SyntaxSoul.TaskTracker.DTOs.TaskDto;
import com.SyntaxSoul.TaskTracker.Mappers.TaskMapper;
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
    @Autowired
    private TaskMapper taskMapper;


    public  List<TaskDto> GetTasks(UUID taskListId) {
        List<Task> tasks=taskRepository.findByTaskListId(taskListId);
        return taskMapper.totaskDtoList(tasks);
    }

    public TaskDto putTasks(UUID taskListId, @RequestBody Task task) {
        TaskList taskList=taskListRepository.findById(taskListId).orElseThrow();
        task.setTaskList(taskList);
        Task savedTask= taskRepository.save(task);
        return taskMapper.toTaskDto(task);
    }


    public TaskDto GetTask(UUID taskId, UUID taskListId) {
        Task task= taskRepository.findByIdAndTaskListId(taskId,taskListId);
        return taskMapper.toTaskDto(task);
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
