package com.dharmendra.hibernateLearning.springdatajaptutorial.repository;

import com.dharmendra.hibernateLearning.springdatajaptutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    // We can retreive the results using the queries from database in hibernate using @Query Annotation
    /*
      @Query: This annotation is useful when we want to get the result using user defined query. We can pass two types of queries. JPQL queries and native SQL queries to this annotation

      JPQL queries: JPQL is Java Persistence Query Language defined in JPA specification. It is used to create queries against entities to store in a relational database.
                      JPQL is developed based on SQL syntax.  But it won’t affect the database directly. JPQL queries are defined using the classes/entities created not with the database tables and columns

       Native SQL Queries: These are general SQL statements which executes by referring the tables and columns in the database

       For the placeholders in the query we are using ?1 ==> which represents the first parameter of the method. If there are more parameters then its not good to pass ?1 or ?2.
         Its better to have some names for these placeholders which are called QueryNamedParams


      @Modifying: This annotation is used when we want the update or delete the records in the database
      @Transactional: This annotation is used along with @Modifying, since updating the records and commiting back to database is a transaction. So we use @Transactional
     */



    @Query("Select s from Student s where s.emailId = ?1")
    public List<Student> getStudentByEmailAddress(String emailId);

    @Query("Select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String emailId);

    @Query(value = "Select * from tbl_student s where s.email_address=?1", nativeQuery = true)
    public List<Student> getStudentByEmailAddressNativeQuery(String emailId);

    @Query(value = "Select * from tbl_student s where s.email_address= :emailId", nativeQuery = true)
    public List<Student> getStudentByEmailAddressNativeQueryNamedParams(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name=?1 where email_address=?2", nativeQuery = true)
    public int updateStudentNameByEmailAddress(String firstName, String emailAddress);



}
