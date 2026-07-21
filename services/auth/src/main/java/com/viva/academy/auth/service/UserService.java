package com.viva.academy.auth.service;

import com.viva.academy.auth.dto.request.UserRequestDto;
import com.viva.academy.auth.dto.response.UserResponseDto;
import com.viva.academy.auth.enums.UserStatus;
import com.viva.academy.auth.model.RoleEntity;
import com.viva.academy.auth.model.UsersEntity;
import com.viva.academy.auth.client.AdminServiceClient;
import com.viva.academy.auth.dto.response.ApiResponse;
import com.viva.academy.auth.repository.RoleRepository;
import com.viva.academy.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import feign.FeignException;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import com.viva.academy.auth.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AdminServiceClient adminServiceClient;

    public UserResponseDto saveUser(UserRequestDto request) {
        // 1. Verify Role exists locally
        RoleEntity role = roleRepository.findById(request.roleId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + request.roleId()));

        // 2. Verify Branch exists in Admin service
        try {
            ApiResponse<Object> branchResponse = adminServiceClient.getBranchById(request.branchId());
            if (branchResponse == null || !"SUCCESS".equals(branchResponse.getStatus())) {
                throw new ResourceNotFoundException("Branch not found with id: " + request.branchId());
            }
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException("Branch not found with id: " + request.branchId());
        } catch (FeignException e) {
            throw new RuntimeException("Error verifying branch with Admin service: " + e.getMessage());
        }

        UsersEntity entity = UsersEntity.builder()
                .userId(request.userId())
                .branchId(request.branchId())
                .role(role)
                .name(request.name())
                .email(request.email())
                .mobile(request.mobile())
                .passwordHash(request.password()) // in a real app, hash this password
                .status(UserStatus.ACTIVE)
                .lastLogin(ZonedDateTime.now())
                .build();

        UsersEntity saved = userRepository.save(entity);
        return mapToResponse(saved);
    }

    public List<UserResponseDto> fetchAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public UserResponseDto fetchUserById(String id) {
        UsersEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return mapToResponse(entity);
    }

    private UserResponseDto mapToResponse(UsersEntity entity) {
        return new UserResponseDto(
                entity.getUserId(),
                entity.getBranchId(),
                entity.getRole().getRoleId(),
                entity.getName(),
                entity.getEmail(),
                entity.getMobile(),
                entity.getStatus(),
                entity.getLastLogin(),
                entity.getCreatedAt()
        );
    }
}
