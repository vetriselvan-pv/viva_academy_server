package com.viva.academy.admin.model;

import com.viva.academy.admin.enums.CourseStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="COURSES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CoursesEntity {

    @Id
    @Column(name = "COURSE_ID")
    private Long courseId;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @Column(name = "DURATION")
    private int duration;

    @Column(name="FEE_AMOUNT")
    private BigDecimal feeAmount;

    @Column(name="STATUS")
    private CourseStatus status;
}
