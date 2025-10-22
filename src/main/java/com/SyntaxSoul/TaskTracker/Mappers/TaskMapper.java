package com.SyntaxSoul.TaskTracker.Mappers;

import com.SyntaxSoul.TaskTracker.DTOs.TaskDto;
import com.SyntaxSoul.TaskTracker.Models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toTask(TaskDto taskDto);

    TaskDto toTaskDto(Task task);
    List<TaskDto> totaskDtoList(List<Task> tasks);
}
