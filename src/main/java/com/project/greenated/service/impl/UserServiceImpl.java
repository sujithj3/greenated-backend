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
import com.project.greenated.model.Roles;
import com.project.greenated.model.Users;
import com.project.greenated.repository.RolesRepository;
import com.project.greenated.repository.UsersRepository;
import com.project.greenated.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RolesRepository rolerepository;

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

	    /* ================= ROLE ================= */
	    Roles role = rolerepository.findById(dto.getRoleId())
	            .orElseThrow(() -> new RuntimeException("Role not found"));
	    user.setRoles(role);

	    /* ================= PARENT USER ================= */
	    if (dto.getParentId() != null) {
	        Users parent = usersRepository.findById(dto.getParentId())
	                .orElseThrow(() -> new RuntimeException("Parent user not found"));
	        user.setParent(parent);
	    }

	   
	    Users savedUser = usersRepository.save(user);
	    return userMapper.toDto(savedUser);
	}
	 @Override
	    public List<UsersDto> getUsersByParentAndRoleName(Integer parentId,String roleName) {
	        return userMapper.toDtoList(
	                usersRepository.findUsersByParentAndRoleName(parentId,roleName)
	        );
	    }
	 @Override
	    public List<UsersDto> getRootUsers() {
	        return userMapper.toDtoList(
	                usersRepository.findByParentIsNull()
	        );
	    }
}
