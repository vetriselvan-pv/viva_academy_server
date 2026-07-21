package com.viva.academy.students.service;

import com.viva.academy.students.dto.request.StudentFeePlanRequestDto;
import com.viva.academy.students.dto.response.StudentFeePlanResponseDto;

import java.util.List;

public interface StudentFeePlanService {
    StudentFeePlanResponseDto createFeePlan(StudentFeePlanRequestDto requestDto);
    List<StudentFeePlanResponseDto> getFeePlans(String studentId);
    void deleteFeePlan(String planId);
}
