package com.dharmendra.hibernateLearning.springdatajaptutorial.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 Embeddable: It means this particular class will be used in another class which is called entity .
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name ="guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name ="guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name ="guardian_mobile")
        )
})
public class Guardian {

    /*
      So here the fields for the guardian class have different naming conventions compared to database. In database these fields are represented as
        guardian_name, guardian_email, guardian_mobile. In order to map with the column names in the database we need to use AttributeOverrides Annotation
     */
    private String name;
    private String email;
    private String mobile;
}
