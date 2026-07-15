package com.viva.academy.students.dto.request;

import com.viva.academy.students.enums.BranchStatus;
import jakarta.validation.constraints.*;

public record BranchRequestDto(

       @NotBlank(message = "Branch name cannot be blank")
       String branchName,

       @NotBlank(message = "Address cannot be blank")
       String address,

       @NotBlank(message = "City cannot be blank")
       String city,

       @NotBlank(message = "State cannot be blank")
       String state,

       @NotBlank(message = "Phone number cannot be blank")
       @Pattern(regexp = "^\\+?[0-9]{10,13}$", message = "Invalid mobile number format")
       String phone,

       @Email(message = "Invalid email address")
       String email,

       @NotBlank(message = "Status cannot be blank")
       @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Invalid status")
       BranchStatus status

) {
}
