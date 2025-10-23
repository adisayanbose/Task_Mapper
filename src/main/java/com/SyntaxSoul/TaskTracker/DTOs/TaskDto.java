package com.SyntaxSoul.TaskTracker.DTOs;

import com.SyntaxSoul.TaskTracker.Models.TaskPriority;
import com.SyntaxSoul.TaskTracker.Models.TaskStatus;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@JsonPropertyOrder({})
public class TaskDto {
    private UUID id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
    private TaskListSummaryDto taskList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
