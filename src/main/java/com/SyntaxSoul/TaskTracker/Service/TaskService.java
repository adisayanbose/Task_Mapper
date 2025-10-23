package com.SyntaxSoul.TaskTracker.Service;

import com.SyntaxSoul.TaskTracker.DTOs.TaskDto;
import com.SyntaxSoul.TaskTracker.DTOs.TaskRequestDto;
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

    public TaskDto putTasks(UUID taskListId, @RequestBody TaskRequestDto taskRequest) {
        TaskList taskList=taskListRepository.findById(taskListId).orElseThrow();
        Task task=taskMapper.toTask(taskRequest);
        task.setTaskList(taskList);
        Task savedTask= taskRepository.save(task);
        return taskMapper.toTaskDto(savedTask);
    }


    public TaskDto GetTask(UUID taskId, UUID taskListId) {
        Task task= taskRepository.findByIdAndTaskListId(taskId,taskListId);
        return taskMapper.toTaskDto(task);
    }

    public TaskDto UpdateTask(UUID taskId, UUID task_list_id, TaskRequestDto taskRequestDto) {
        Task exisitingTask=taskRepository.findById(taskId).orElseThrow();
        taskMapper.toTask(exisitingTask,taskRequestDto);
        Task updatedTask= taskRepository.save(exisitingTask);
        return taskMapper.toTaskDto(updatedTask);
    }

    public TaskDto deleteTask(UUID taskId) {
        Task task=taskRepository.findById(taskId).orElseThrow();
        taskRepository.deleteById(taskId);
        return  taskMapper.toTaskDto(task);
    }
}
