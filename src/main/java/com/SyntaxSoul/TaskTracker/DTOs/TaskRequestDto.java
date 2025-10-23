package com.SyntaxSoul.TaskTracker.DTOs;

import com.SyntaxSoul.TaskTracker.Models.TaskPriority;
import com.SyntaxSoul.TaskTracker.Models.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskRequestDto {
    private String title;
    private String description;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private LocalDate dueDate;
}
