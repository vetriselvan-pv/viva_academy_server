package com.viva.academy.students.service;

import com.viva.academy.students.dto.request.EnquiryRequestDto;
import com.viva.academy.students.dto.response.EnquiryResponseDto;

import java.util.List;

public interface EnquiryService {
    EnquiryResponseDto createEnquiry(EnquiryRequestDto requestDto);
    EnquiryResponseDto getEnquiryById(Long enquiryId);
    List<EnquiryResponseDto> getAllEnquiries();
    void deleteEnquiry(Long enquiryId);
}
