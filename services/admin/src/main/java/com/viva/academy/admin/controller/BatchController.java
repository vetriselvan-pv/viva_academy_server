package com.viva.academy.admin.controller;

import com.viva.academy.admin.dto.request.BatchRequestDto;
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
    public ResponseEntity<BatchResponseDto> saveBatch(@Valid @RequestBody BatchRequestDto request) {
        BatchResponseDto response = batchService.saveBatch(request);
        URI location = URI.create("/v1/batches/" + response.batchId());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<List<BatchResponseDto>> fetchBatches() {
        List<BatchResponseDto> response = batchService.fetchAllBatches();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatchResponseDto> fetchBatchById(@PathVariable("id") Long id) {
        BatchResponseDto response = batchService.fetchBatchById(id);
        return ResponseEntity.ok(response);
    }
}
