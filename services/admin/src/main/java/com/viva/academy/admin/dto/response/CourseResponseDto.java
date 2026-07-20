package com.viva.academy.admin.dto.response;

import com.viva.academy.admin.enums.CourseStatus;

import java.math.BigDecimal;

public record CourseResponseDto(
        Long courseId,
        String courseName,
        BigDecimal feeAmount,
        int duration,
        CourseStatus status
) {
}
