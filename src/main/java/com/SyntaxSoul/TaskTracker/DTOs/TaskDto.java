package com.SyntaxSoul.TaskTracker.DTOs;

import com.SyntaxSoul.TaskTracker.Models.TaskPriority;
import com.SyntaxSoul.TaskTracker.Models.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDto {
    private String Title;
    private String Description;
    private LocalDate dueDate;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
    private TaskListSummaryDto taskList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
