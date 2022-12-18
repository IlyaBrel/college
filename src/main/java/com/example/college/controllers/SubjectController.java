package com.example.college.controllers;

import com.example.college.model.Subject;
import com.example.college.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/")
    public String subjects(@RequestParam(name = "title",required = false) String title, Model model) {
        model.addAttribute("subjects", subjectService.listSubjects(title));
        return "subjects";
    }
    @GetMapping("/subject/{id}")
    public String subjectInfo(@PathVariable Long id, Model model){
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject",subject);
        model.addAttribute("image",subject.getImages());
        return "subjects-info";
    }

    @PostMapping("/subject/create")
    public String createSubject(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                 @RequestParam("file3") MultipartFile file3, Subject subject) throws IOException {
        subjectService.saveSubject(subject, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/subject/delete/{id}")
    public String deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return "redirect:/";
    }


}
