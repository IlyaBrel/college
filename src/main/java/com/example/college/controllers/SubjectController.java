package com.example.college.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubjectController {
    @GetMapping("/")
    public String products() {
        return "products";
    }
}
