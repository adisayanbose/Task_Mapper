package com.SyntaxSoul.TaskTracker.Mappers;

import com.SyntaxSoul.TaskTracker.DTOs.TaskListDto;
import com.SyntaxSoul.TaskTracker.DTOs.TaskListRequestDto;
import com.SyntaxSoul.TaskTracker.DTOs.TaskListSummaryDto;
import com.SyntaxSoul.TaskTracker.DTOs.TaskRequestDto;
import com.SyntaxSoul.TaskTracker.Models.TaskList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy=NullValuePropertyMappingStrategy.IGNORE)
public interface TaskListMapper {
    TaskList toTaskList(TaskListDto taskListDto);
    TaskListDto toTaskListDto(TaskList taskList);
    TaskListSummaryDto toTaskListSummaryDto(TaskList taskList);
    List<TaskListSummaryDto> taskListSummaryDtoList(List<TaskList> taskLists);
    TaskList toTaskList(TaskListRequestDto taskListRequestDto);

    TaskList toTaskList(@MappingTarget TaskList taskList, TaskListRequestDto taskListRequestDto);
}
