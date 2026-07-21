package com.viva.academy.students.controller;

import com.viva.academy.common.dto.response.ApiResponse;
import com.viva.academy.students.dto.request.StudentDocumentRequestDto;
import com.viva.academy.students.dto.response.StudentDocumentResponseDto;
import com.viva.academy.students.service.StudentDocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/documents")
@RequiredArgsConstructor
public class StudentDocumentController {

    private final StudentDocumentService studentDocumentService;

    @PostMapping
    public ResponseEntity<ApiResponse<StudentDocumentResponseDto>> createDocument(@Valid @RequestBody StudentDocumentRequestDto requestDto) {
        StudentDocumentResponseDto response = studentDocumentService.createDocument(requestDto);
        return new ResponseEntity<>(ApiResponse.success(response, "Student document created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ApiResponse<List<StudentDocumentResponseDto>>> getDocuments(@PathVariable String studentId) {
        List<StudentDocumentResponseDto> response = studentDocumentService.getDocuments(studentId);
        return ResponseEntity.ok(ApiResponse.success(response, "Student documents fetched successfully"));
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<ApiResponse<Void>> deleteDocument(@PathVariable Long documentId) {
        studentDocumentService.deleteDocument(documentId);
        return ResponseEntity.ok(ApiResponse.success(null, "Student document deleted successfully"));
    }
}
