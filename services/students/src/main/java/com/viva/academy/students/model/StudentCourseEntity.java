package com.viva.academy.students.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "STUDENT_COURSES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(StudentCourseId.class)
public class StudentCourseEntity {

    @Id
    @Column(name = "STUDENT_ID")
    private String studentId;

    @Id
    @Column(name = "BRANCH_ID")
    private Long branchId;

    @Id
    @Column(name = "COURSE_ID")
    private Long courseId;

    @Id
    @Column(name = "BATCH_ID")
    private Long batchId;

    @Column(name = "ADMISSION_DATE", nullable = false)
    private LocalDateTime admissionDate;

    @Column(name = "REMARKS", length = 100)
    private String remarks;

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;
}
