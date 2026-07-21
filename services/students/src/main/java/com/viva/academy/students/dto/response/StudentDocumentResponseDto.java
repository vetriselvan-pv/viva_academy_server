package com.viva.academy.students.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDocumentResponseDto {

    private Long documentId;
    private String studentId;
    private String documentType;
    private String file;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
