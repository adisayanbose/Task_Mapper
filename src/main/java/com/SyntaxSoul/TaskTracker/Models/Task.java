package com.SyntaxSoul.TaskTracker.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task extends  BaseModel{

    @Temporal(TemporalType.DATE)
    private LocalDate dueDate;

    private TaskPriority taskPriority;

    private TaskStatus taskStatus;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private TaskList taskList;



}
