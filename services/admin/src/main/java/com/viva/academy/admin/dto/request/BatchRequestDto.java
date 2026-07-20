package com.viva.academy.admin.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;

public record BatchRequestDto(
        @NotNull(message = "Course ID is required")
        Long courseId,

        @NotBlank(message = "Branch ID is required")
        String branchId,

        @NotBlank(message = "Batch name cannot be blank")
        @Size(max = 100, message = "Batch name must be up to 100 characters")
        String batchName,

        @NotNull(message = "Start date is required")
        OffsetDateTime startDate,

        OffsetDateTime endDate,
        Integer capacity
) {}
