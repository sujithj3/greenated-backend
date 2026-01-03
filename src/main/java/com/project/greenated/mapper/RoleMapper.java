package com.project.greenated.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.greenated.dto.RoleDto;
import com.project.greenated.model.Roles;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    // DTO → Entity (for create)
    @Mapping(target = "roleId", ignore = true)
    Roles toEntity(RoleDto dto);

    // Entity → DTO
    RoleDto toDto(Roles role);
}