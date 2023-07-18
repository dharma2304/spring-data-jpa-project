package com.dharmendra.hibernateLearning.springdatajaptutorial.entity;

import jakarta.persistence.*;
import lombok.*;

/*
@OneToOne: It specifies that the particular class/entity has OneToOne relationship with other entity. In our case each course has only one course material and each course material
           is associated with only one course. And we will have the primary key of course in our course material entity which acts as a foreign key.

@JoinColumn: It is necessary in the entity which owns the primary key of other entity to map the primary key of the other entity with the field present in the current entity

     For example CourseMaterial is the entity which owns the primary key of Course entity. We are mapping the courseId(primarykey) of Course with the field course_id in the CouseMaterial Entity.

Cascading: Cascading is a way that any action taken on target entity will be applied to associate entity. Its like passing the properties or permissions from parent entity to
           target entity. Entity relationships often depend on the existence of another entity, for example the Person–Address relationship. Without the Person,
           the Address entity doesn't have any meaning of its own. When we delete the Person entity, our Address entity should also get deleted.


 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseMaterialId;
    private String url;

    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
