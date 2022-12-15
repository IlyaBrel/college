package com.example.college.controllers;

import com.example.college.model.Subject;
import com.example.college.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/")
    public String subjects(Model model) {
        model.addAttribute("subjects", subjectService.listSubjects());
        return "subjects";
    }
    @GetMapping("/subject/{id}")
    public String subjectInfo(@PathVariable Long id, Model model){
        model.addAttribute("subject",subjectService.getSubjectById(id));
        return "subjects-info";
    }

    @PostMapping("/subject/create")
    public String createSubject(Subject subject){
            subjectService.saveSubject(subject);
            return "redirect:/";
    }

    @PostMapping("/subject/delete/{id}")
    public String deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return "redirect:/";
    }


}
