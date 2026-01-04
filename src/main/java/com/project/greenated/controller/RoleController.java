package com.project.greenated.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.greenated.dto.ResponseDto;
import com.project.greenated.dto.RoleDto;
import com.project.greenated.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
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

	private final RoleService roleService;

	@PostMapping("/create")
	public ResponseDto createRole(@RequestBody RoleDto dto) {
		try {
			RoleDto response = roleService.createRole(dto);
			return new ResponseDto(false, successCode, successMsg, response);
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
	}

	@GetMapping("/get/name/{roleName}")
	public ResponseDto getRoleByName(@PathVariable String roleName) {
		try {
			RoleDto response = roleService.getRoleByName(roleName);
			return new ResponseDto(false, successCode, successMsg, response);
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
	}
}

   