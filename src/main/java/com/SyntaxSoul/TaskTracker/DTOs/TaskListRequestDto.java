package com.SyntaxSoul.TaskTracker.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class TaskListRequestDto {
    private String title;
    private String description;
}
