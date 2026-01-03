package com.project.greenated.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.greenated.dto.LoginResponseDto;
import com.project.greenated.dto.PermissionsDto;
import com.project.greenated.dto.UsersDto;
import com.project.greenated.mapper.UserMapper;
import com.project.greenated.model.RolePermissions;
import com.project.greenated.model.Users;
import com.project.greenated.repository.UsersRepository;
import com.project.greenated.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public Users findByUsername(String username) {
		return usersRepository.findByUsername(username);
	}

	@Override
	public LoginResponseDto loadUserDetails(String username, String password) {
		List<Users> UsersList;
		LoginResponseDto response = null;
		UsersList = usersRepository.loadUserDetails(username, password);
		if (UsersList != null & UsersList.size() > 0) {
			Users usersdetails = (Users) UsersList.get(0);
			response = new LoginResponseDto();
			response.setUserId(usersdetails.getUserId());
			response.setName(usersdetails.getName());
			response.setEmail(usersdetails.getEmail());
			response.setToken("");
			response.setRoleId(usersdetails.getRoles().getRoleId());
			response.setRoleName(usersdetails.getRoles().getRoleName());
			Set<RolePermissions> rolePermissions = usersdetails.getRoles().getRolePermissions();

			List<PermissionsDto> permissionsDtoList = rolePermissions.stream().map(rp -> {
				PermissionsDto dto = new PermissionsDto();
				dto.setPermissionId(rp.getPermission().getPermissionId());
				dto.setPermissionKey(rp.getPermission().getPermissionkey());
				return dto;
			}).toList();

			// ✅ SET DTO LIST
			response.setPermissions(permissionsDtoList);

		}
		return response;
	}
	 @Override
	 public UsersDto createUser(UsersDto dto) {

	        Users user = userMapper.toEntity(dto);

	        if (dto.getParentId() != null) {
	            Users parent = usersRepository.findById(dto.getParentId())
	                    .orElseThrow(() -> new RuntimeException("Parent user not found"));
	            user.setParent(parent);
	        }

	        return userMapper.toDto(usersRepository.save(user));
	    }
	 @Override
	    public List<UsersDto> getUsersByParent(Integer parentId) {
	        return userMapper.toDtoList(
	                usersRepository.findByParent_UserId(parentId)
	        );
	    }
	 @Override
	    public List<UsersDto> getRootUsers() {
	        return userMapper.toDtoList(
	                usersRepository.findByParentIsNull()
	        );
	    }
}
