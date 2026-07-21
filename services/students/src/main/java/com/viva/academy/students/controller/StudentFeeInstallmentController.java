package com.viva.academy.students.controller;

import com.viva.academy.common.dto.response.ApiResponse;
import com.viva.academy.students.dto.request.StudentFeeInstallmentRequestDto;
import com.viva.academy.students.dto.response.StudentFeeInstallmentResponseDto;
import com.viva.academy.students.service.StudentFeeInstallmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/fee-installments")
@RequiredArgsConstructor
public class StudentFeeInstallmentController {

    private final StudentFeeInstallmentService installmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<StudentFeeInstallmentResponseDto>> createInstallment(@Valid @RequestBody StudentFeeInstallmentRequestDto requestDto) {
        StudentFeeInstallmentResponseDto response = installmentService.createInstallment(requestDto);
        return new ResponseEntity<>(ApiResponse.success(response, "Fee installment created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<ApiResponse<List<StudentFeeInstallmentResponseDto>>> getInstallments(@PathVariable String planId) {
        List<StudentFeeInstallmentResponseDto> response = installmentService.getInstallments(planId);
        return ResponseEntity.ok(ApiResponse.success(response, "Fee installments fetched successfully"));
    }

    @DeleteMapping("/{installmentId}")
    public ResponseEntity<ApiResponse<Void>> deleteInstallment(@PathVariable String installmentId) {
        installmentService.deleteInstallment(installmentId);
        return ResponseEntity.ok(ApiResponse.success(null, "Fee installment deleted successfully"));
    }
}
