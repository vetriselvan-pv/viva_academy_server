package com.viva.academy.admin.controller;

import com.viva.academy.admin.dto.request.BatchRequestDto;
import com.viva.academy.common.dto.response.ApiResponse;
import com.viva.academy.admin.dto.response.BatchResponseDto;
import com.viva.academy.admin.service.BatchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/batches")
@RequiredArgsConstructor
public class BatchController {
    private final BatchService batchService;

    @PostMapping
    public ResponseEntity<ApiResponse<BatchResponseDto>> saveBatch(@Valid @RequestBody BatchRequestDto request) {
        BatchResponseDto response = batchService.saveBatch(request);
        URI location = URI.create("/v1/batches/" + response.batchId());
        return ResponseEntity.created(location).body(ApiResponse.success(response, "Batch created successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BatchResponseDto>>> fetchBatches() {
        List<BatchResponseDto> response = batchService.fetchAllBatches();
        return ResponseEntity.ok(ApiResponse.success(response, "Batches fetched successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BatchResponseDto>> fetchBatchById(@PathVariable("id") Long id) {
        BatchResponseDto response = batchService.fetchBatchById(id);
        return ResponseEntity.ok(ApiResponse.success(response, "Batch fetched successfully"));
    }
}
