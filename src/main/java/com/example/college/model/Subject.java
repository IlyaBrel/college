package com.example.college.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {

    private Long id;
    private String title;
    private String description;
    private String author;

}
