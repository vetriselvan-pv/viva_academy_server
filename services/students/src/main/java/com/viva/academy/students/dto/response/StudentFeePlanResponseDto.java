package com.viva.academy.students.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentFeePlanResponseDto {

    private String planId;
    private String studentId;
    private BigDecimal totalFee;
    private BigDecimal discount;
    private BigDecimal netFee;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
