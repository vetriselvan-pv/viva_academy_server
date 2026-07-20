package com.viva.academy.admin.dto.request;

import com.viva.academy.admin.enums.CourseStatus;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CourseRequestDto(

        @NotNull(message = "Course Name cannot be empty")
        String courseName ,

        @NotNull(message="Duration cannot be empty")
        int duration ,

        @NotNull(message = "Fee Amount cannot be empty")
        BigDecimal feeAmount,

        @NotNull(message = "Status cannot be empty")
        CourseStatus status


) {
}
