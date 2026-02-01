package com.samyak.projecttool.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicPageController {

    @GetMapping("/")
    public String landing() {
        return "public/landing";
    }

    @GetMapping("/login")
    public String login() {
        return "public/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "public/signup";
    }
}
