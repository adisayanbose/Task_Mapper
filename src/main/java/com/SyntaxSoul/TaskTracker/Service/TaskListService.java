package com.SyntaxSoul.TaskTracker.Service;

import com.SyntaxSoul.TaskTracker.Models.TaskList;
import com.SyntaxSoul.TaskTracker.Repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository taskListRepository;

    public List<TaskList> GetTaskLists()
    {
        return taskListRepository.findAll();
    }

    public TaskList AddTaskList(TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    public Optional<TaskList> GetTaskListById(UUID id) {
        return taskListRepository.findById(id);
    }

    public TaskList PutTaskListById(UUID id, TaskList taskList) {
        taskList.setId(id);
        return taskListRepository.save(taskList);
    }

    public String DeleteTaskListById(UUID id) {
         taskListRepository.deleteById(id);
        return "deleted successfully";
    }
}
