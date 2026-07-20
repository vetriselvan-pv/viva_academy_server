package com.viva.academy.auth.dto.request;

import jakarta.validation.constraints.NotNull;

public record RolesRequestDto(
        @NotNull(message = "Role Id cannot be empty")
        String roleId,

        @NotNull(message = "Role Name cannot be empty")
        String roleName,

        @NotNull(message = "Description cannot be empty")
        String description
) {
}
