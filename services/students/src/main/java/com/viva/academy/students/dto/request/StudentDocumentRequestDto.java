package com.viva.academy.students.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDocumentRequestDto {

    @NotBlank(message = "Student ID is mandatory")
    private String studentId;

    @NotBlank(message = "Document type is mandatory")
    private String documentType;

    @NotBlank(message = "File is mandatory")
    private String file;
}
