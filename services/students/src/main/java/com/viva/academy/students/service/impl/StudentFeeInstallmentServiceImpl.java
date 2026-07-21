package com.viva.academy.students.service.impl;

import com.viva.academy.common.exception.ResourceNotFoundException;
import com.viva.academy.students.dto.request.StudentFeeInstallmentRequestDto;
import com.viva.academy.students.dto.response.StudentFeeInstallmentResponseDto;
import com.viva.academy.students.enums.StudentFeeInstallmentStatus;
import com.viva.academy.students.model.StudentFeeInstallmentEntity;
import com.viva.academy.students.repository.StudentFeeInstallmentRepository;
import com.viva.academy.students.service.StudentFeeInstallmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentFeeInstallmentServiceImpl implements StudentFeeInstallmentService {

    private final StudentFeeInstallmentRepository installmentRepository;

    @Override
    public StudentFeeInstallmentResponseDto createInstallment(StudentFeeInstallmentRequestDto requestDto) {
        StudentFeeInstallmentEntity entity = StudentFeeInstallmentEntity.builder()
                .installmentId(requestDto.getInstallmentId())
                .planId(requestDto.getPlanId())
                .dueDate(requestDto.getDueDate())
                .amount(requestDto.getAmount())
                .status(requestDto.getStatus() != null ? 
                        StudentFeeInstallmentStatus.valueOf(requestDto.getStatus().toUpperCase()) : 
                        StudentFeeInstallmentStatus.PENDING)
                .build();
        StudentFeeInstallmentEntity saved = installmentRepository.save(entity);
        return mapToResponse(saved);
    }

    @Override
    public List<StudentFeeInstallmentResponseDto> getInstallments(String planId) {
        return installmentRepository.findByPlanId(planId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteInstallment(String installmentId) {
        if (!installmentRepository.existsById(installmentId)) {
            throw new ResourceNotFoundException("Installment not found with ID: " + installmentId);
        }
        installmentRepository.deleteById(installmentId);
    }

    private StudentFeeInstallmentResponseDto mapToResponse(StudentFeeInstallmentEntity entity) {
        return StudentFeeInstallmentResponseDto.builder()
                .installmentId(entity.getInstallmentId())
                .planId(entity.getPlanId())
                .dueDate(entity.getDueDate())
                .amount(entity.getAmount())
                .status(entity.getStatus().name())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
