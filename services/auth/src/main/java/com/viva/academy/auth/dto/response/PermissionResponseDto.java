package com.viva.academy.auth.dto.response;

public record PermissionResponseDto(
        String permissionId,
        String permissionName,
        String module
) {
}
