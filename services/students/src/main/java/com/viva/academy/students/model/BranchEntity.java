package com.viva.academy.students.model;


import com.viva.academy.students.enums.BranchStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.OffsetDateTime;

@Entity
@Table(name = "BRANCHES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchEntity {

    @Id
    @Column(name = "BRANCH_ID", nullable = false )
    private String branchId;

    @Column(name = "BRANCH_NAME", nullable = false)
    private String branchName;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", nullable = false)
    private BranchStatus status;

    @CreatedDate
    @Column(name = "CREATED_AT", updatable = false,  nullable = false)
    private OffsetDateTime createdAt;

}
