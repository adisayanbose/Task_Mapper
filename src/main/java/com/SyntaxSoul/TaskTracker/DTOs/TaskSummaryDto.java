package com.SyntaxSoul.TaskTracker.DTOs;

import com.SyntaxSoul.TaskTracker.Models.TaskPriority;
import com.SyntaxSoul.TaskTracker.Models.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class TaskSummaryDto {
    private UUID Id;
    private String Title;
    private String description;
    private LocalDate dueDate;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
}
