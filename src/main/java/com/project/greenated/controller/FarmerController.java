package com.project.greenated.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.greenated.dto.FarmerRequestDto;
import com.project.greenated.dto.FarmerResponseDto;
import com.project.greenated.dto.ResponseDto;
import com.project.greenated.service.FarmerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/farmers")
@RequiredArgsConstructor
@CrossOrigin
public class FarmerController {
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
    private  FarmerService farmerService;
    
	@PostMapping("/create")
	public ResponseDto createFarmerByUser(@RequestBody FarmerRequestDto dto) {

		try {
			FarmerResponseDto response = farmerService.createFarmer(dto);
			return new ResponseDto(false, successCode, successMsg, response);
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
	}

    @PutMapping("/edit/{farmerId}")
    public ResponseDto updateFarmerByUser(
            @PathVariable Integer farmerId,
            @RequestBody FarmerRequestDto dto) {
    	try {
    		FarmerResponseDto response = farmerService.updateFarmer(farmerId, dto);
    		return new ResponseDto(false, successCode, successMsg, response);
    	} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
	}
    @GetMapping("/get/user/{userId}")
    public ResponseDto getFarmerByUser(
            @PathVariable Integer userId) {
        try {
			List<FarmerResponseDto> response =  farmerService.getFarmersByUser(userId);
			return new ResponseDto(false, successCode, successMsg, response);
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
    }
}