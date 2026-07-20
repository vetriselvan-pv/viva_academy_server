package com.viva.academy.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDto(
        @NotBlank(message = "User ID cannot be blank")
        @Size(max = 15, message = "User ID must be up to 15 characters")
        String userId,

        @NotNull(message = "Branch ID is required")
        Long branchId,

        @NotBlank(message = "Role ID is required")
        String roleId,

        @NotBlank(message = "Name cannot be blank")
        @Size(max = 40, message = "Name must be up to 40 characters")
        String name,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Mobile cannot be blank")
        String mobile,

        @NotBlank(message = "Password cannot be blank")
        String password
) {}
