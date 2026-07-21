package com.viva.academy.students.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentFeePlanRequestDto {

    @NotBlank(message = "Plan ID is mandatory")
    private String planId;

    @NotBlank(message = "Student ID is mandatory")
    private String studentId;

    @NotNull(message = "Total fee is mandatory")
    private BigDecimal totalFee;

    @NotNull(message = "Discount is mandatory")
    private BigDecimal discount;

    @NotNull(message = "Net fee is mandatory")
    private BigDecimal netFee;
}
