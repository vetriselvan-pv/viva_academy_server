package com.viva.academy.admin.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "BATCHES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchesEntity {

    @Id
    @Column(name = "BATCH_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID", nullable = false)
    private CoursesEntity course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCH_ID", nullable = false)
    private BranchEntity branch;

    @Column(name = "BATCH_NAME", nullable = false, length = 100)
    private String batchName;

    @Column(name = "START_DATE", nullable = false)
    private OffsetDateTime startDate;

    @Column(name = "END_DATE")
    private OffsetDateTime endDate;

    @Column(name = "CAPACITY")
    private Integer capacity;
}
