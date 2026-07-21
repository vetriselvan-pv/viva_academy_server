package com.viva.academy.students.controller;

import com.viva.academy.common.dto.response.ApiResponse;
import com.viva.academy.students.dto.request.EnquiryRequestDto;
import com.viva.academy.students.dto.response.EnquiryResponseDto;
import com.viva.academy.students.service.EnquiryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/enquiries")
@RequiredArgsConstructor
public class EnquiryController {

    private final EnquiryService enquiryService;

    @PostMapping
    public ResponseEntity<ApiResponse<EnquiryResponseDto>> createEnquiry(@Valid @RequestBody EnquiryRequestDto requestDto) {
        EnquiryResponseDto response = enquiryService.createEnquiry(requestDto);
        return new ResponseEntity<>(ApiResponse.success(response, "Enquiry created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/{enquiryId}")
    public ResponseEntity<ApiResponse<EnquiryResponseDto>> getEnquiry(@PathVariable Long enquiryId) {
        EnquiryResponseDto response = enquiryService.getEnquiryById(enquiryId);
        return ResponseEntity.ok(ApiResponse.success(response, "Enquiry fetched successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EnquiryResponseDto>>> getAllEnquiries() {
        List<EnquiryResponseDto> response = enquiryService.getAllEnquiries();
        return ResponseEntity.ok(ApiResponse.success(response, "Enquiries fetched successfully"));
    }

    @DeleteMapping("/{enquiryId}")
    public ResponseEntity<ApiResponse<Void>> deleteEnquiry(@PathVariable Long enquiryId) {
        enquiryService.deleteEnquiry(enquiryId);
        return ResponseEntity.ok(ApiResponse.success(null, "Enquiry deleted successfully"));
    }
}
