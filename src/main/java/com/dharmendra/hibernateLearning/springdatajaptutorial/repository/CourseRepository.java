package com.dharmendra.hibernateLearning.springdatajaptutorial.repository;

import com.dharmendra.hibernateLearning.springdatajaptutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
