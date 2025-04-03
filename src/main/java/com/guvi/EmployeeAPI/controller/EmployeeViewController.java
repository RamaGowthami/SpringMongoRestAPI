package com.guvi.EmployeeAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EmployeeViewController {

    @GetMapping
    public String index() {
        return "redirect:/index.html"; // Redirects to static HTML page
    }
}
