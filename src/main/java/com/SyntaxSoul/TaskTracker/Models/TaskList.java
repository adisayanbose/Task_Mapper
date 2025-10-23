package com.SyntaxSoul.TaskTracker.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskList extends  BaseModel{

    @OneToMany(mappedBy = "taskList",cascade = CascadeType.REMOVE)
    private List<Task> tasks;


}
