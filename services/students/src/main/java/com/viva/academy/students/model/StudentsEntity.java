package com.viva.academy.students.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name="STUDENTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsEntity {
    @Id
    @Column(name="STUDENT_ID")
    private String studentId;

    @Column(name = "Name")
    private String name;

    @Column(name="GENDER")
    private String gender;

    @Column(name="DOB")
    private LocalDate dob;

    @Column(name="MOBILE")
    private String mobile;

    @Column(name="EMAIL")
    private String email;

}
