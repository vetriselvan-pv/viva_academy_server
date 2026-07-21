package com.viva.academy.students.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryRequestDto {

    private Long branchId;

    @NotBlank(message = "Lead source is mandatory")
    private String leadSource;

    @NotBlank(message = "Student name is mandatory")
    private String studentName;

    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid mobile number format")
    private String mobile;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    private String email;

    private String courseId;

    @NotBlank(message = "Status is mandatory")
    private String status;

    @NotNull(message = "Next follow up date is mandatory")
    private LocalDateTime nextFollowUp;

    private String remarks;
}
