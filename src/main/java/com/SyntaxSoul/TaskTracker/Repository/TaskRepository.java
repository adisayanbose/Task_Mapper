package com.SyntaxSoul.TaskTracker.Repository;

import com.SyntaxSoul.TaskTracker.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findByTaskListId(UUID id);

    Task findByIdAndTaskListId(UUID taskId, UUID taskListId);
}