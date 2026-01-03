package com.project.greenated.service;

import com.project.greenated.dto.RoleDto;

public interface RoleService {

	 RoleDto createRole(RoleDto dto);

	    RoleDto getRoleByName(String roleName);
}