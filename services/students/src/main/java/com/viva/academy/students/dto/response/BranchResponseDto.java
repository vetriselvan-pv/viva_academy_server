package com.viva.academy.students.dto.response;

import com.viva.academy.students.enums.BranchStatus;

import java.time.OffsetDateTime;

public record BranchResponseDto(
        String branchId,
        String branchName,
        String address,
        String city,
        String email,
        String phone,
        OffsetDateTime createdAt,
        BranchStatus status
) {
}
