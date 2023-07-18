package com.dharmendra.hibernateLearning.springdatajaptutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 Annotations Description

 @Table: It specifies the table in the database with which this entity is mapped.
 @Column: It specifies that the field in the entity is mapped with the column in that particular table
 @GeneratedValue: Generally for columns like id which has integer data type

 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "unique constraints",
                columnNames = "email_address"
        )
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
}
