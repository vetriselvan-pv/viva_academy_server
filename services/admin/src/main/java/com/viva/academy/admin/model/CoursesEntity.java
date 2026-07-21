package com.viva.academy.admin.model;

import com.viva.academy.admin.enums.CourseStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "COURSES")
@EntityListeners(AuditingEntityListener.class)
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

    @Column(name = "FEE_AMOUNT")
    private BigDecimal feeAmount;

    @Column(name = "STATUS")
    private CourseStatus status;

    @CreatedDate
    @Column(name = "CREATED_AT", updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    private OffsetDateTime updatedAt;

    @CreatedBy
    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "UPDATED_BY")
    private String updatedBy;
}
