package com.viva.academy.admin.dto.response;

import java.time.OffsetDateTime;

public record BatchResponseDto(
        Long batchId,
        Long courseId,
        String branchId,
        String batchName,
        OffsetDateTime startDate,
        OffsetDateTime endDate,
        Integer capacity
) {}
