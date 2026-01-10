package com.project.greenated.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.greenated.dto.AddressDto;
import com.project.greenated.dto.LocationAddressDto;
import com.project.greenated.dto.ResponseDto;
import com.project.greenated.service.LocationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin
@RequiredArgsConstructor
public class LocationController {
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
    private  LocationService locationService;

    
    @GetMapping("/countries")
    public ResponseDto getCountries() {

		try {
			List<AddressDto> response = locationService.getAllCountries();
			return new ResponseDto(false, successCode, successMsg, response);
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
	}

    @GetMapping("/states/{countryId}")
    public ResponseDto getStates(
            @PathVariable Integer countryId) {
    	try {
			List<AddressDto> response =locationService.getStatesByCountry(countryId);
			return new ResponseDto(false, successCode, successMsg, response);
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
	}
    
    @GetMapping("/districts/{stateId}")
    public ResponseDto getDistricts(
            @PathVariable Integer stateId) {
    	try {
			List<LocationAddressDto> response =locationService.getDistrictByState(stateId);
			return new ResponseDto(false, successCode, successMsg, response);
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
	}
       
}

