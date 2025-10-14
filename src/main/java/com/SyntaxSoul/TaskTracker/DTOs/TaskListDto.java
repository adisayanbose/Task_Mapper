package com.SyntaxSoul.TaskTracker.DTOs;

import com.SyntaxSoul.TaskTracker.Models.Task;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TaskListDto {
    private UUID id;
    private  String Title;
    private String Description;
    private List<TaskSummaryDto> taskSummaryDtos;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
