package com.example.college.services;


import com.example.college.model.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    private List<Subject> subjects = new ArrayList<>();
    private long ID = 0;

    {
        subjects.add(new Subject(++ID, "mat", "toda", "me"));
        subjects.add(new Subject(++ID, "fiz", "toda", "we"));
    }

    public List<Subject> listSubjects() {
        return subjects;
    }

    public void saveSubject(Subject subject) {
        subject.setId(++ID);
        subjects.add(subject);
    }

    public void deleteSubject(Long id) {
        subjects.removeIf(subject -> subject.getId().equals(id));
    }

    public Subject getSubjectById(Long id) {

        for (Subject subject : subjects) {
            if (subject.getId().equals(id)) return subject;
        }
        return null;
    }

}
