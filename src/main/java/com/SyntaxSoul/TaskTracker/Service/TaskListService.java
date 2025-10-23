package com.SyntaxSoul.TaskTracker.Service;

import com.SyntaxSoul.TaskTracker.DTOs.TaskListDto;
import com.SyntaxSoul.TaskTracker.DTOs.TaskListRequestDto;
import com.SyntaxSoul.TaskTracker.DTOs.TaskListSummaryDto;
import com.SyntaxSoul.TaskTracker.Mappers.TaskListMapper;
import com.SyntaxSoul.TaskTracker.Mappers.TaskMapper;
import com.SyntaxSoul.TaskTracker.Models.TaskList;
import com.SyntaxSoul.TaskTracker.Repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository taskListRepository;
    @Autowired
    private TaskListMapper taskListMapper;

    public List<TaskListSummaryDto> GetTaskLists()
    {
        List<TaskList> taskLists=taskListRepository.findAll();
        return taskListMapper.taskListSummaryDtoList(taskLists);
    }

    public TaskListDto AddTaskList(TaskListRequestDto taskListDto) {
        TaskList taskList=taskListMapper.toTaskList(taskListDto);
        TaskList SavedTaskList=taskListRepository.save(taskList);
        return taskListMapper.toTaskListDto(SavedTaskList);
    }

    public TaskListDto GetTaskListById(UUID id) {
          TaskList taskList= taskListRepository.findById(id).orElseThrow();
        return taskListMapper.toTaskListDto(taskList);
    }

    public TaskListDto PutTaskListById(UUID id, TaskListRequestDto taskListRequestDto) {
        TaskList existingTaskList=taskListRepository.findById(id).orElseThrow();
        TaskList taskList=taskListMapper.toTaskList(existingTaskList,taskListRequestDto);
        taskList.setId(id);
        TaskList savedTaskList=taskListRepository.save(taskList);
        return taskListMapper.toTaskListDto(savedTaskList);
    }

    public TaskListDto DeleteTaskListById(UUID id) {
        TaskList taskList=taskListRepository.findById(id).orElseThrow();
        taskListRepository.delete(taskList);
        return taskListMapper.toTaskListDto(taskList);
    }
}
