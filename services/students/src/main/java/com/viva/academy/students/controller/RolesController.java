package com.viva.academy.students.controller;


import com.viva.academy.students.dto.request.RolesRequestDto;
import com.viva.academy.students.dto.response.RolesResponseDto;
import com.viva.academy.students.model.RoleEntity;
import com.viva.academy.students.service.RoleService;
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
    public ResponseEntity<RolesResponseDto> createRoles(@Valid @RequestBody RolesRequestDto request) {
        RolesResponseDto response = roleService.saveRole(request);
        return new ResponseEntity<RolesResponseDto>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RolesResponseDto>> getRoles(){
        List<RolesResponseDto> response = roleService.findAllRoles();
        return new ResponseEntity<List<RolesResponseDto>>(response,HttpStatus.OK);
    }

}
