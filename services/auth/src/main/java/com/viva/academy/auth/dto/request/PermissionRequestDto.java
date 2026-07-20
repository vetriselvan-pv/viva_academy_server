package com.viva.academy.auth.dto.request;

import jakarta.validation.constraints.NotNull;

public record PermissionRequestDto(
        @NotNull(message = "Permission Name cannot be empty")
        String permissionName,

        @NotNull(message =  "Module cannot be empty")
        String module
) {
}
