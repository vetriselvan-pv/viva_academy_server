package com.viva.academy.students.controller;


import com.viva.academy.students.dto.request.BranchRequestDto;
import com.viva.academy.students.dto.response.BranchResponseDto;
import com.viva.academy.students.service.BranchService;
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
    public ResponseEntity<BranchResponseDto> createBranch(@RequestBody BranchRequestDto request){
        BranchResponseDto response = branchService.createBranch(request);
        return new ResponseEntity<BranchResponseDto>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BranchResponseDto>> getBranch() {
        List<BranchResponseDto> response = branchService.getBranches();
        return new ResponseEntity<List<BranchResponseDto>>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<BranchResponseDto> getBranchById(@RequestParam String branchId){
        BranchResponseDto response = branchService.getBranch(branchId);
        return new ResponseEntity<BranchResponseDto>(response, HttpStatus.OK);
    }
}
