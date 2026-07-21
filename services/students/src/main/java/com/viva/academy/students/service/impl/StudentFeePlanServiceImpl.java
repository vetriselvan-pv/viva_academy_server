package com.viva.academy.students.service.impl;

import com.viva.academy.common.exception.ResourceNotFoundException;
import com.viva.academy.students.dto.request.StudentFeePlanRequestDto;
import com.viva.academy.students.dto.response.StudentFeePlanResponseDto;
import com.viva.academy.students.model.StudentFeePlanEntity;
import com.viva.academy.students.repository.StudentFeePlanRepository;
import com.viva.academy.students.service.StudentFeePlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentFeePlanServiceImpl implements StudentFeePlanService {

    private final StudentFeePlanRepository studentFeePlanRepository;

    @Override
    public StudentFeePlanResponseDto createFeePlan(StudentFeePlanRequestDto requestDto) {
        StudentFeePlanEntity entity = StudentFeePlanEntity.builder()
                .planId(requestDto.getPlanId())
                .studentId(requestDto.getStudentId())
                .totalFee(requestDto.getTotalFee())
                .discount(requestDto.getDiscount())
                .netFee(requestDto.getNetFee())
                .build();
        StudentFeePlanEntity saved = studentFeePlanRepository.save(entity);
        return mapToResponse(saved);
    }

    @Override
    public List<StudentFeePlanResponseDto> getFeePlans(String studentId) {
        return studentFeePlanRepository.findByStudentId(studentId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFeePlan(String planId) {
        if (!studentFeePlanRepository.existsById(planId)) {
            throw new ResourceNotFoundException("Fee plan not found with ID: " + planId);
        }
        studentFeePlanRepository.deleteById(planId);
    }

    private StudentFeePlanResponseDto mapToResponse(StudentFeePlanEntity entity) {
        return StudentFeePlanResponseDto.builder()
                .planId(entity.getPlanId())
                .studentId(entity.getStudentId())
                .totalFee(entity.getTotalFee())
                .discount(entity.getDiscount())
                .netFee(entity.getNetFee())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
