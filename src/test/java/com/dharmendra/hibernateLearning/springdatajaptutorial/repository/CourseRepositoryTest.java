package com.dharmendra.hibernateLearning.springdatajaptutorial.repository;

import com.dharmendra.hibernateLearning.springdatajaptutorial.entity.Course;
import com.dharmendra.hibernateLearning.springdatajaptutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Sankar")
                .lastName("Narayan")
                .build();


        Course course = Course.builder()
                .courseTitle("Python")
                .credits(3)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}