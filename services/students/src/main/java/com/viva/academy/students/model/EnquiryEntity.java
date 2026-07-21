package com.viva.academy.students.model;

import com.viva.academy.students.enums.EnquiryStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "ENQUIRIES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnquiryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENQUIRY_ID")
    private Long enquiryId;

    @Column(name = "BRANCH_ID")
    private Long branchId;

    @Column(name = "LEAD_SOURCE", nullable = false, length = 50)
    private String leadSource;

    @Column(name = "STUDENT_NAME", nullable = false, length = 100)
    private String studentName;

    @Column(name = "MOBILE", nullable = false, columnDefinition = "TEXT")
    private String mobile;

    @Column(name = "EMAIL", nullable = false, columnDefinition = "CITEXT")
    private String email;

    @Column(name = "COURSE_ID", length = 20)
    private String courseId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private EnquiryStatus status;

    @Column(name = "NEXT_FOLLOW_UP", nullable = false)
    private LocalDateTime nextFollowUp;

    @Column(name = "REMARKS", columnDefinition = "TEXT")
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
