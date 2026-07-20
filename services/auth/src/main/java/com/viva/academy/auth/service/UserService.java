package com.viva.academy.auth.service;

import com.viva.academy.auth.dto.request.UserRequestDto;
import com.viva.academy.auth.dto.response.UserResponseDto;
import com.viva.academy.auth.enums.UserStatus;
import com.viva.academy.auth.model.RoleEntity;
import com.viva.academy.auth.model.UsersEntity;
import com.viva.academy.auth.repository.RoleRepository;
import com.viva.academy.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserResponseDto saveUser(UserRequestDto request) {
        RoleEntity role = roleRepository.findById(request.roleId())
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + request.roleId()));

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
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
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
