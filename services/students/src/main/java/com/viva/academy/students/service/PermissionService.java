package com.viva.academy.students.service;


import com.viva.academy.students.dto.request.PermissionRequestDto;
import com.viva.academy.students.dto.response.PermissionResponseDto;
import com.viva.academy.students.model.PermissionEntity;
import com.viva.academy.students.repository.PermissionRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;

    @Transactional
    public PermissionResponseDto savePermission(PermissionRequestDto request){
        Long nextPermissionId  =  permissionRepository.getPermissionId();
        String generatedCode = String.format("PER%03d", nextPermissionId);
        PermissionEntity entity = PermissionEntity.builder().permissionId(generatedCode)
                .permissionName(request.permissionName())
                .module(request.permissionName()).build();
        return transformToResponse(entity);
    }

    @Transactional
    public List<PermissionResponseDto> fetchAll(){
        List<PermissionEntity> entity = permissionRepository.findAll();
        return entity.stream().map(this::transformToResponse).toList();
    }

    private PermissionResponseDto transformToResponse(PermissionEntity entity){
        return new PermissionResponseDto(entity.getPermissionId(), entity.getPermissionName(), entity.getModule());
    }
}
