package com.viva.academy.students.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseRequestDto {

    @NotBlank(message = "Student ID is mandatory")
    private String studentId;

    @NotNull(message = "Branch ID is mandatory")
    private Long branchId;

    @NotNull(message = "Course ID is mandatory")
    private Long courseId;

    @NotNull(message = "Batch ID is mandatory")
    private Long batchId;

    @NotNull(message = "Admission date is mandatory")
    private LocalDateTime admissionDate;

    private String remarks;
}
