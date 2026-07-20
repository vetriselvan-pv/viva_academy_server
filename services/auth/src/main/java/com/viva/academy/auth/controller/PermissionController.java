package com.viva.academy.auth.controller;


import com.viva.academy.auth.dto.request.PermissionRequestDto;
import com.viva.academy.auth.dto.response.PermissionResponseDto;
import com.viva.academy.auth.service.PermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/permission")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<PermissionResponseDto> savePermission(@Valid @RequestBody PermissionRequestDto request){
        PermissionResponseDto response = permissionService.savePermission(request);
        return new ResponseEntity<PermissionResponseDto>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<PermissionResponseDto>> findAllPermission(){
        List<PermissionResponseDto> response = permissionService.fetchAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
