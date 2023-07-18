package com.dharmendra.hibernateLearning.springdatajaptutorial.repository;

import com.dharmendra.hibernateLearning.springdatajaptutorial.entity.Course;
import com.dharmendra.hibernateLearning.springdatajaptutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeachers(){

        Course courseML = Course.builder()
                .courseTitle("ML")
                .credits(3)
                .build();
        Course courseDB = Course.builder()
                .courseTitle("DBMS")
                .credits(3)
                .build();
        List<Course> courses = new ArrayList<>();
        courses.add(courseML);
        courses.add(courseDB);

//        Teacher teacher = Teacher.builder()
//                .firstName("Dharmendra")
//                .lastName("Makineni")
//                .courses(courses)
//                .build();
//        teacherRepository.save(teacher);
    }

}