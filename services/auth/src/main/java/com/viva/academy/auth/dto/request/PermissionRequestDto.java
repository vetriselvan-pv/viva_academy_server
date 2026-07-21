package com.viva.academy.auth.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PermissionRequestDto(
                @NotBlank(message = "Permission Name cannot be empty") String permissionName,

                @NotBlank(message = "Module cannot be empty") String module) {
}
