package com.viva.academy.students.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "STUDENTS_FEE_PLANS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentFeePlanEntity {

    @Id
    @Column(name = "PLAN_ID", length = 20)
    private String planId;

    @Column(name = "STUDENT_ID", length = 30)
    private String studentId;

    @Column(name = "TOTAL_FEE", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalFee;

    @Column(name = "DISCOUNT", nullable = false, precision = 12, scale = 2)
    private BigDecimal discount;

    @Column(name = "NET_FEE", nullable = false, precision = 12, scale = 2)
    private BigDecimal netFee;

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
