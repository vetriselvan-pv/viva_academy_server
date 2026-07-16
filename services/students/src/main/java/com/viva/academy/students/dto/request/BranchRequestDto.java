package com.viva.academy.students.dto.request;

import com.viva.academy.students.enums.BranchStatus;
import jakarta.validation.constraints.*;

public record BranchRequestDto(

       @NotBlank(message = "Branch name cannot be blank")
       @Size(min = 3, max = 50)
       String branchName,

       @NotBlank(message = "Address cannot be blank")
       @Size(min = 5, max = 150)
       String address,

       @NotBlank(message = "City cannot be blank")
       @Size(min = 5, max = 20)
       String city,
       
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
