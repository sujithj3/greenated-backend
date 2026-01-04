package com.project.greenated.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.project.greenated.dto.UsersDto;
import com.project.greenated.model.Users;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(target = "roles", ignore = true)
    @Mapping(target = "parent", ignore = true)
    Users toEntity(UsersDto dto);

    @Mapping(source = "roles.roleId", target = "roleId")
    @Mapping(source = "parent.userId", target = "parentId")
    UsersDto toDto(Users user);
    
    List<UsersDto> toDtoList(List<Users> users);

    @Mapping(target = "parent", ignore = true)
    void updateEntityFromDto(UsersDto dto, @MappingTarget Users user);
}