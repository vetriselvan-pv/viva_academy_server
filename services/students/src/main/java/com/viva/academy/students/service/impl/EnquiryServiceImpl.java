package com.viva.academy.students.service.impl;

import com.viva.academy.common.exception.ResourceNotFoundException;
import com.viva.academy.students.dto.request.EnquiryRequestDto;
import com.viva.academy.students.dto.response.EnquiryResponseDto;
import com.viva.academy.students.enums.EnquiryStatus;
import com.viva.academy.students.model.EnquiryEntity;
import com.viva.academy.students.repository.EnquiryRepository;
import com.viva.academy.students.service.EnquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnquiryServiceImpl implements EnquiryService {

    private final EnquiryRepository enquiryRepository;

    @Override
    public EnquiryResponseDto createEnquiry(EnquiryRequestDto requestDto) {
        EnquiryEntity entity = EnquiryEntity.builder()
                .branchId(requestDto.getBranchId())
                .leadSource(requestDto.getLeadSource())
                .studentName(requestDto.getStudentName())
                .mobile(requestDto.getMobile())
                .email(requestDto.getEmail())
                .courseId(requestDto.getCourseId())
                .status(EnquiryStatus.valueOf(requestDto.getStatus().toUpperCase()))
                .nextFollowUp(requestDto.getNextFollowUp())
                .remarks(requestDto.getRemarks())
                .build();
        EnquiryEntity saved = enquiryRepository.save(entity);
        return mapToResponse(saved);
    }

    @Override
    public EnquiryResponseDto getEnquiryById(Long enquiryId) {
        EnquiryEntity entity = enquiryRepository.findById(enquiryId)
                .orElseThrow(() -> new ResourceNotFoundException("Enquiry not found with ID: " + enquiryId));
        return mapToResponse(entity);
    }

    @Override
    public List<EnquiryResponseDto> getAllEnquiries() {
        return enquiryRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEnquiry(Long enquiryId) {
        if (!enquiryRepository.existsById(enquiryId)) {
            throw new ResourceNotFoundException("Enquiry not found with ID: " + enquiryId);
        }
        enquiryRepository.deleteById(enquiryId);
    }

    private EnquiryResponseDto mapToResponse(EnquiryEntity entity) {
        return EnquiryResponseDto.builder()
                .enquiryId(entity.getEnquiryId())
                .branchId(entity.getBranchId())
                .leadSource(entity.getLeadSource())
                .studentName(entity.getStudentName())
                .mobile(entity.getMobile())
                .email(entity.getEmail())
                .courseId(entity.getCourseId())
                .status(entity.getStatus().name())
                .nextFollowUp(entity.getNextFollowUp())
                .remarks(entity.getRemarks())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
