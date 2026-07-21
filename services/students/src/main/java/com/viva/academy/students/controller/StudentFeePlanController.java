package com.viva.academy.students.controller;

import com.viva.academy.common.dto.response.ApiResponse;
import com.viva.academy.students.dto.request.StudentFeePlanRequestDto;
import com.viva.academy.students.dto.response.StudentFeePlanResponseDto;
import com.viva.academy.students.service.StudentFeePlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/fee-plans")
@RequiredArgsConstructor
public class StudentFeePlanController {

    private final StudentFeePlanService studentFeePlanService;

    @PostMapping
    public ResponseEntity<ApiResponse<StudentFeePlanResponseDto>> createFeePlan(@Valid @RequestBody StudentFeePlanRequestDto requestDto) {
        StudentFeePlanResponseDto response = studentFeePlanService.createFeePlan(requestDto);
        return new ResponseEntity<>(ApiResponse.success(response, "Fee plan created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ApiResponse<List<StudentFeePlanResponseDto>>> getFeePlans(@PathVariable String studentId) {
        List<StudentFeePlanResponseDto> response = studentFeePlanService.getFeePlans(studentId);
        return ResponseEntity.ok(ApiResponse.success(response, "Fee plans fetched successfully"));
    }

    @DeleteMapping("/{planId}")
    public ResponseEntity<ApiResponse<Void>> deleteFeePlan(@PathVariable String planId) {
        studentFeePlanService.deleteFeePlan(planId);
        return ResponseEntity.ok(ApiResponse.success(null, "Fee plan deleted successfully"));
    }
}
