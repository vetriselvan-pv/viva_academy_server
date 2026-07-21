package com.viva.academy.students.service.impl;

import com.viva.academy.common.exception.ResourceNotFoundException;
import com.viva.academy.students.dto.request.StudentDocumentRequestDto;
import com.viva.academy.students.dto.response.StudentDocumentResponseDto;
import com.viva.academy.students.model.StudentDocumentEntity;
import com.viva.academy.students.repository.StudentDocumentRepository;
import com.viva.academy.students.service.StudentDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentDocumentServiceImpl implements StudentDocumentService {

    private final StudentDocumentRepository studentDocumentRepository;

    @Override
    public StudentDocumentResponseDto createDocument(StudentDocumentRequestDto requestDto) {
        StudentDocumentEntity entity = StudentDocumentEntity.builder()
                .studentId(requestDto.getStudentId())
                .documentType(requestDto.getDocumentType())
                .file(requestDto.getFile())
                .build();
        StudentDocumentEntity saved = studentDocumentRepository.save(entity);
        return mapToResponse(saved);
    }

    @Override
    public List<StudentDocumentResponseDto> getDocuments(String studentId) {
        return studentDocumentRepository.findByStudentId(studentId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDocument(Long documentId) {
        if (!studentDocumentRepository.existsById(documentId)) {
            throw new ResourceNotFoundException("Document not found with ID: " + documentId);
        }
        studentDocumentRepository.deleteById(documentId);
    }

    private StudentDocumentResponseDto mapToResponse(StudentDocumentEntity entity) {
        return StudentDocumentResponseDto.builder()
                .documentId(entity.getDocumentId())
                .studentId(entity.getStudentId())
                .documentType(entity.getDocumentType())
                .file(entity.getFile())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
