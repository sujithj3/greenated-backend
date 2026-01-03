package com.project.greenated.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
	private Integer userId;
	private String name;
    private String email;
    private String token;
	private Integer roleId;
	private String roleName;
	private List<PermissionsDto> permissions;
   
}
