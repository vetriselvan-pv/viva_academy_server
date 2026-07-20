package com.viva.academy.auth.service;

import com.viva.academy.auth.dto.request.RolesRequestDto;
import com.viva.academy.auth.dto.response.RolesResponseDto;
import com.viva.academy.auth.model.RoleEntity;
import com.viva.academy.auth.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RolesRepository rolesRepository;

    @Transactional
    public RolesResponseDto saveRole( RolesRequestDto request){
        RoleEntity roleEntity = RoleEntity.builder().roleId(request.roleId()).
                roleName(request.roleName()).description((request.description())).build();
        RoleEntity role = rolesRepository.save(roleEntity);
        return transformToResponse(role);
    }

    @Transactional(readOnly = true)
    public List<RolesResponseDto> findAllRoles(){
        List<RoleEntity> entity = rolesRepository.findAll();
        return entity.stream().map(this::transformToResponse).toList();
    }

    private RolesResponseDto transformToResponse( RoleEntity role){
        return new RolesResponseDto(role.getRoleId(), role.getRoleName(), role.getDescription());
    }

}
