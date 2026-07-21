package com.viva.academy.auth.controller;


import com.viva.academy.auth.dto.request.RolesRequestDto;
import com.viva.academy.auth.dto.response.ApiResponse;
import com.viva.academy.auth.dto.response.RolesResponseDto;
import com.viva.academy.auth.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/roles")
@RequiredArgsConstructor
public class RolesController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<ApiResponse<RolesResponseDto>> createRoles(@Valid @RequestBody RolesRequestDto request) {
        RolesResponseDto response = roleService.saveRole(request);
        return new ResponseEntity<>(ApiResponse.success(response, "Role created successfully"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<RolesResponseDto>>> getRoles(){
        List<RolesResponseDto> response = roleService.findAllRoles();
        return new ResponseEntity<>(ApiResponse.success(response, "Roles fetched successfully"),HttpStatus.OK);
    }

}
