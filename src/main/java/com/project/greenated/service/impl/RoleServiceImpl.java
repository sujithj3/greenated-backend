package com.project.greenated.service.impl;

import org.springframework.stereotype.Service;

import com.project.greenated.dto.RoleDto;
import com.project.greenated.mapper.RoleMapper;
import com.project.greenated.model.Roles;
import com.project.greenated.repository.RolesRepository;
import com.project.greenated.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RolesRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto createRole(RoleDto dto) {

        if (roleRepository.existsByRoleNameIgnoreCase(dto.getRoleName())) {
            throw new RuntimeException("Role already exists");
        }

        Roles role = roleMapper.toEntity(dto);
        role.setRoleName(dto.getRoleName().toUpperCase());

        Roles savedRole = roleRepository.save(role);
        return roleMapper.toDto(savedRole);
    }

    @Override
    public RoleDto getRoleByName(String roleName) {

        Roles role = roleRepository.findByRoleNameIgnoreCase(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        return roleMapper.toDto(role);
    }
}