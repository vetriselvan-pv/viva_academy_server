package com.viva.academy.students.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class StudentFeeInstallmentRequestDto {

    @NotBlank(message = "Installment ID is mandatory")
    private String installmentId;

    @NotBlank(message = "Plan ID is mandatory")
    private String planId;

    @NotNull(message = "Due date is mandatory")
    private LocalDateTime dueDate;

    @NotNull(message = "Amount is mandatory")
    private BigDecimal amount;
    
    private String status;
}
