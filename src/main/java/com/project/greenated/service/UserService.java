package com.project.greenated.service;

import java.util.List;

import com.project.greenated.dto.LoginResponseDto;
import com.project.greenated.dto.UsersDto;
import com.project.greenated.model.Users;

public interface UserService {
	public Users findByUsername(String username);
	
	public LoginResponseDto loadUserDetails(String username,String password);
	
	 public UsersDto createUser(UsersDto dto);
	 
	 public List<UsersDto> getUsersByParentAndRoleName(Integer parentId,String roleName);
	 
	 public List<UsersDto> getRootUsers();
}
