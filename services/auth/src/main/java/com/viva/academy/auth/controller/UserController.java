package com.viva.academy.auth.controller;

import com.viva.academy.auth.dto.request.UserRequestDto;
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
    public ResponseEntity<UserResponseDto> saveUser(@Valid @RequestBody UserRequestDto request) {
        UserResponseDto response = userService.saveUser(request);
        URI location = URI.create("/v1/users/" + response.userId());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> fetchUsers() {
        List<UserResponseDto> response = userService.fetchAllUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> fetchUserById(@PathVariable("id") String id) {
        UserResponseDto response = userService.fetchUserById(id);
        return ResponseEntity.ok(response);
    }
}
