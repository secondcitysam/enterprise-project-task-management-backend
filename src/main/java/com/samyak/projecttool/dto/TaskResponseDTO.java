package com.samyak.projecttool.dto;

import com.samyak.projecttool.entity.enums.TaskPriority;
import com.samyak.projecttool.entity.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResponseDTO {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime createdAt;
}
