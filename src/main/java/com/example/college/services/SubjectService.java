package com.example.college.services;


import com.example.college.model.Image;
import com.example.college.model.Subject;
import com.example.college.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service

@Slf4j
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;


    public List<Subject> listSubjects(String title) {
        if (title != null) return subjectRepository.findByTitle(title);
        return subjectRepository.findAll();
    }

    public void saveSubject(Subject subject, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            subject.addImageToSubject(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            subject.addImageToSubject(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            subject.addImageToSubject(image3);
        }
        log.info("Saving new Product. Title: {}, Author: {}", subject.getTitle(), subject.getAuthor());
        Subject subjectFromDb = subjectRepository.save(subject);
        subjectFromDb.setPreviewImageId(subjectFromDb.getImages().get(0).getId());
        subjectRepository.save(subject);
    }

    private Image toImageEntity(MultipartFile file)throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

}
