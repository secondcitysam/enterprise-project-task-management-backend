package com.samyak.projecttool.repository;

import com.samyak.projecttool.entity.Task;
import com.samyak.projecttool.entity.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Used when validating task under a project
     */
    Optional<Task> findByIdAndProjectId(Long id, Long projectId);

    /**
     * Project details page
     */
    List<Task> findAllByProjectId(Long projectId);

    /**
     * Hide archived tasks by default
     */
    List<Task> findAllByProjectIdAndStatusNot(
            Long projectId,
            TaskStatus status
    );

    /**
     * Task-level state checks
     */
    Optional<Task> findByIdAndStatus(Long id, TaskStatus status);
}
