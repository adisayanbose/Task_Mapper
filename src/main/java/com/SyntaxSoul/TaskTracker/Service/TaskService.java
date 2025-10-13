package com.SyntaxSoul.TaskTracker.Service;

import com.SyntaxSoul.TaskTracker.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;



public class TaskService {

    @Autowired
   private TaskRepository taskRepository;


}
