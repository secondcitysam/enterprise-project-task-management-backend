package com.samyak.projecttool.controller.page;

import com.samyak.projecttool.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {

    private final ProjectService projectService;

    public DashboardController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam Long userId, Model model) {

        model.addAttribute("projects",
                projectService.getProjects(userId));

        model.addAttribute("userId", userId);
        return "dashboard/dashboard";
    }
}
