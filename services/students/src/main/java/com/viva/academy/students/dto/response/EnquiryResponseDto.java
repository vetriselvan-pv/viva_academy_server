package com.viva.academy.students.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryResponseDto {

    private Long enquiryId;
    private Long branchId;
    private String leadSource;
    private String studentName;
    private String mobile;
    private String email;
    private String courseId;
    private String status;
    private LocalDateTime nextFollowUp;
    private String remarks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
