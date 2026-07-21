package com.viva.academy.students.service;

import com.viva.academy.students.dto.request.StudentDocumentRequestDto;
import com.viva.academy.students.dto.response.StudentDocumentResponseDto;

import java.util.List;

public interface StudentDocumentService {
    StudentDocumentResponseDto createDocument(StudentDocumentRequestDto requestDto);
    List<StudentDocumentResponseDto> getDocuments(String studentId);
    void deleteDocument(Long documentId);
}
