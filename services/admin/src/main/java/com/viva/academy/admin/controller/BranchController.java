package com.viva.academy.admin.controller;


import com.viva.academy.admin.dto.request.BranchRequestDto;
import com.viva.academy.admin.dto.response.ApiResponse;
import com.viva.academy.admin.dto.response.BranchResponseDto;
import com.viva.academy.admin.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public ResponseEntity<ApiResponse<BranchResponseDto>> createBranch(@RequestBody BranchRequestDto request){
        BranchResponseDto response = branchService.createBranch(request);
        return new ResponseEntity<>(ApiResponse.success(response, "Branch created successfully"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BranchResponseDto>>> getBranch() {
        List<BranchResponseDto> response = branchService.getBranches();
        return new ResponseEntity<>(ApiResponse.success(response, "Branches fetched successfully"), HttpStatus.OK);
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<ApiResponse<BranchResponseDto>> getBranchById(@PathVariable("branchId") String branchId){
        BranchResponseDto response = branchService.getBranch(branchId);
        return new ResponseEntity<>(ApiResponse.success(response, "Branch fetched successfully"), HttpStatus.OK);
    }
}
