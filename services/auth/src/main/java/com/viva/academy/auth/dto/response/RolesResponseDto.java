package com.viva.academy.auth.dto.response;

public record RolesResponseDto(
        String roleId,
        String roleName,
        String description
) {
}
