package com.project.greenated.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.greenated.dto.LoginDto;
import com.project.greenated.dto.LoginResponseDto;
import com.project.greenated.dto.ResponseDto;
import com.project.greenated.dto.UsersDto;
import com.project.greenated.service.UserService;
import com.project.greenated.util.JwtUserDetailsService;
import com.project.greenated.util.JwtUtil;



@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {
	@Value("${code.success}") 
	private int successCode;

	@Value("${code.fail}")
	private int failCode;

	@Value("${code.error.bad-request}")
	private int badRequestCode;	

	@Value("${code.error.service-error}")
	private int serviceErrorCode;

	@Value("${message.success}")
	private String successMsg;

	@Value("${message.fail}")
	private String failMsg;

	@Value("${message.error.bad-request}")
	private String badRequestMsg;

	@Value("${message.error.service-error}")
	private String serviceErrorMsg;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public ResponseDto createAuthenticationToken(@RequestBody LoginDto loginDto){						
		try {
			LoginResponseDto user;
			final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());
			String token = jwtUtil.generateToken(userDetails);
			user = userService.loadUserDetails(loginDto.getUsername(),loginDto.getPassword() );
			user.setToken(token);	
			return new ResponseDto(false, successCode, successMsg, user);
		} catch (Exception e) {
			return new ResponseDto(true, badRequestCode, "Login Failed",e.getMessage());
		}			
	}
	
	@PostMapping("/create")
    public ResponseDto createUser(@RequestBody UsersDto usersDto) {
        try {
            UsersDto user = userService.createUser(usersDto);
            return new ResponseDto(false, successCode, successMsg, user);
        } catch (Exception e) {
            return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
        }
    }

	@GetMapping("/by-parent/{parentId}/{roleName}")
	public ResponseDto getUsersByParentAndRole(@PathVariable Integer parentId,@PathVariable String roleName) {
		try {
			return new ResponseDto(false, successCode, successMsg, userService.getUsersByParentAndRoleName(parentId,roleName));
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, serviceErrorMsg);
		}
	}

	@GetMapping("/root")
	public ResponseDto getRootUsers() {
		try {
			return new ResponseDto(false, successCode, successMsg, userService.getRootUsers());
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, serviceErrorMsg);
		}
	}
}

