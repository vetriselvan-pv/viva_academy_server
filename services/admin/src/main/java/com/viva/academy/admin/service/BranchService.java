package com.viva.academy.admin.service;

import com.viva.academy.admin.dto.request.BranchRequestDto;
import com.viva.academy.admin.dto.response.BranchResponseDto;
import com.viva.academy.admin.model.BranchEntity;
import com.viva.academy.admin.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import com.viva.academy.admin.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;

    @Transactional
    public BranchResponseDto createBranch(BranchRequestDto request) {
        Long nextBranchCode = branchRepository.getBranchCode();
        String generatedCode = String.format("BRA%03d", nextBranchCode);
        BranchEntity branchEntity = BranchEntity.builder().branchId(generatedCode).branchName(request.branchName())
                .email(request.email())
                .address(request.address()).phone(request.phone()).city(request.city()).status(request.status())
                .build();
        BranchEntity savedBranchEntity = branchRepository.save(branchEntity);
        return transformToResponse(savedBranchEntity);
    }

    @Transactional
    public BranchResponseDto updateBranch(BranchRequestDto request) {
        BranchEntity branchEntity = BranchEntity.builder().branchName(request.branchName()).email(request.email())
                .address(request.address()).phone(request.phone()).city(request.city()).status(request.status())
                .build();
        BranchEntity savedBranchEntity = branchRepository.save(branchEntity);
        return transformToResponse(savedBranchEntity);
    }

    @Transactional(readOnly = true)
    public List<BranchResponseDto> getBranches() {
        List<BranchEntity> branchEntities = branchRepository.findAll();
        List<BranchResponseDto> branches = new ArrayList<>();
        for (BranchEntity branchEntity : branchEntities) {
            branches.add(transformToResponse(branchEntity));
        }
        return branches;
    }

    @Transactional(readOnly = true)
    public BranchResponseDto getBranch(String branchName) {
        return branchRepository.findById(branchName).map(this::transformToResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found with ID/Name: " + branchName));
    }

    private BranchResponseDto transformToResponse(BranchEntity branch) {
        return new BranchResponseDto(branch.getBranchId(), branch.getBranchName(), branch.getAddress(),
                branch.getCity(), branch.getEmail(), branch.getPhone(), branch.getCreatedAt(), branch.getStatus());
    }

}