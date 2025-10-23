package com.SyntaxSoul.TaskTracker.Mappers;

import com.SyntaxSoul.TaskTracker.DTOs.TaskDto;
import com.SyntaxSoul.TaskTracker.DTOs.TaskRequestDto;
import com.SyntaxSoul.TaskTracker.Models.Task;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskMapper {

    Task toTask(TaskRequestDto taskRequestDto);

    TaskDto toTaskDto(Task task);
    List<TaskDto> totaskDtoList(List<Task> tasks);

    Task toTask(@MappingTarget Task task,TaskRequestDto taskRequestDto);
}
