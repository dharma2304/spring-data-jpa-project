package com.dharmendra.hibernateLearning.springdatajaptutorial.repository;

import com.dharmendra.hibernateLearning.springdatajaptutorial.entity.Course;
import com.dharmendra.hibernateLearning.springdatajaptutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .courseTitle("Operating Systems")
                .credits(4)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);

    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();
        System.out.println(courseMaterial);
    }


}