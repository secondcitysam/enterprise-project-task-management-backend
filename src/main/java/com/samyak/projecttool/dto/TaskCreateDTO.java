package com.samyak.projecttool.dto;

import com.samyak.projecttool.entity.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskCreateDTO {

    @NotBlank
    private String title;

    private String description;

    private TaskPriority priority;
}
