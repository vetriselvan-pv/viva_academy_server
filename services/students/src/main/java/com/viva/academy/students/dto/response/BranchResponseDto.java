package com.viva.academy.students.dto.response;

import com.viva.academy.students.enums.BranchStatus;

import java.time.OffsetDateTime;

public record BranchResponseDto(
        Long branchId,
        String branchName,
        String branchCode,
        String address,
        String city,
        String state,
        String email,
        String phone,
        OffsetDateTime createdAt,
        BranchStatus status
) {
}
