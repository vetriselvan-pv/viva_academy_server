package com.viva.academy.students.service;

import com.viva.academy.students.dto.request.StudentFeeInstallmentRequestDto;
import com.viva.academy.students.dto.response.StudentFeeInstallmentResponseDto;

import java.util.List;

public interface StudentFeeInstallmentService {
    StudentFeeInstallmentResponseDto createInstallment(StudentFeeInstallmentRequestDto requestDto);
    List<StudentFeeInstallmentResponseDto> getInstallments(String planId);
    void deleteInstallment(String installmentId);
}
