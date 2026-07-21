package com.viva.academy.auth.dto.response;

import com.viva.academy.auth.enums.UserStatus;

import java.time.ZonedDateTime;

public record UserResponseDto(
        String userId,
        String branchId,
        String roleId,
        String name,
        String email,
        String mobile,
        UserStatus status,
        ZonedDateTime lastLogin,
        ZonedDateTime createdAt
) {}
