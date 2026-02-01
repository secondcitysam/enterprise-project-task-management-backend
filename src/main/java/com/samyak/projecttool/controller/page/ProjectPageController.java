package com.samyak.projecttool.controller.page;

import com.samyak.projecttool.dto.ProjectCreateDTO;
import com.samyak.projecttool.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectPageController {

    private final ProjectService projectService;

    public ProjectPageController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createProjectPage(@RequestParam Long userId, Model model) {
        model.addAttribute("project", new ProjectCreateDTO());
        model.addAttribute("userId", userId);
        return "project/project-create";
    }

    @PostMapping("/create")
    public String createProject(@RequestParam Long userId,
                                @Valid @ModelAttribute("project") ProjectCreateDTO dto,
                                BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            model.addAttribute("userId", userId);
            return "project/project-create";
        }

        projectService.createProject(userId, dto);
        return "redirect:/dashboard?userId=" + userId;
    }
}
