package com.dharmendra.hibernateLearning.springdatajaptutorial.repository;

import com.dharmendra.hibernateLearning.springdatajaptutorial.entity.Guardian;
import com.dharmendra.hibernateLearning.springdatajaptutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("Dharmendra")
                .lastName("Makineni")
                .emailId("dharmendra@gmail.com")
//                .guardianName("Koyi")
//                .guardianMobile("9999999999")
//                .guardianEmail("koyi@gmail.com")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = new Guardian("nikhil", "nikhil@gmail.com", "9999999999");
        Student student = Student.builder()
                .firstName("sai")
                .lastName("makineni")
                .emailId("sai@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void getStudentsByFirstName(){
        List<Student> student = studentRepository.findByFirstName("Dharmendra");
        System.out.println(student);
    }

    @Test
    public void getStudentsByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Dh");
        System.out.println(students);
    }

    @Test
    public void getStudentsByLastNameNotNull(){
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println(students);
    }

    @Test
    public void getStudentsByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Koyi");
        System.out.println(students);
    }

    @Test
    public void printStudentsbyEmailAddress(){
        List<Student> list = studentRepository.getStudentByEmailAddress("sai@gmail.com");
        System.out.println(list);
    }

    @Test
    public void printStudentsFistNamebyEmailAddress(){
        String list = studentRepository.getStudentFirstNameByEmailAddress("sai@gmail.com");
        System.out.println(list);
    }

    @Test
    public void printStudentsByEmailAddressNative(){
        List<Student> list = studentRepository.getStudentByEmailAddress("sai@gmail.com");
    }

    @Test
    public void printStudentsByEmailAddressNamedParams(){
        List<Student> list = studentRepository.getStudentByEmailAddressNativeQueryNamedParams("sai@gmail.com");
    }

    @Test
    public void printStudentNameByEmailAddress(){
        studentRepository.updateStudentNameByEmailAddress("Vara Sai Ram", "sai@gmail.com");
    }
}