package com.SyntaxSoul.TaskTracker.Repository;

import com.SyntaxSoul.TaskTracker.Models.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskListRepository extends JpaRepository<TaskList, UUID> {
}