package com.project.greenated.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.greenated.model.Roles;
import com.project.greenated.model.Users;
import com.project.greenated.service.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = userService.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		Roles role = user.getRoles();

		Set<GrantedAuthority> authorities = new HashSet<>();

		authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));

		role.getRolePermissions().forEach(rp -> {
			authorities.add(new SimpleGrantedAuthority(rp.getPermission().getPermissionkey().trim().toUpperCase()));
		});
		authorities.forEach(a -> System.out.println("AUTHORITY: [" + a.getAuthority() + "]"));

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);

	}

}