package com.viva.academy.auth.controller;

import com.viva.academy.auth.dto.request.UserRequestDto;
import com.viva.academy.common.dto.response.ApiResponse;
import com.viva.academy.auth.dto.response.UserResponseDto;
import com.viva.academy.auth.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> saveUser(@Valid @RequestBody UserRequestDto request) {
        UserResponseDto response = userService.saveUser(request);
        URI location = URI.create("/v1/users/" + response.userId());
        return ResponseEntity.created(location).body(ApiResponse.success(response, "User created successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> fetchUsers() {
        List<UserResponseDto> response = userService.fetchAllUsers();
        return ResponseEntity.ok(ApiResponse.success(response, "Users fetched successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> fetchUserById(@PathVariable("id") String id) {
        UserResponseDto response = userService.fetchUserById(id);
        return ResponseEntity.ok(ApiResponse.success(response, "User fetched successfully"));
    }
}
