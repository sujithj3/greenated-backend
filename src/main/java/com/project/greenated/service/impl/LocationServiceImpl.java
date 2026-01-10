package com.project.greenated.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.greenated.dto.AddressDto;
import com.project.greenated.dto.LocationAddressDto;
import com.project.greenated.repository.CountryRepository;
import com.project.greenated.repository.LocationRepository;
import com.project.greenated.repository.StateRepository;
import com.project.greenated.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private LocationRepository locationRepo;
	
	
	
	 @Override
	    public List<AddressDto> getAllCountries() {
	        return countryRepo.findAll()
	                .stream()
	                .map(c -> new AddressDto(c.getCountryId(),c.getCountryName()))
	                .toList();
	    }

	    @Override
	    public List<AddressDto> getStatesByCountry(Integer countryId) {
	        return stateRepo.findByCountry_CountryId(countryId)
	                .stream()
	                .map(s -> new AddressDto(s.getStateId(), s.getStateName()))
	                .toList();
	    }
	    
	    @Override
	    public List<LocationAddressDto> getDistrictByState(Integer stateId) {
	        return locationRepo.findByState_StateId(stateId)
	                .stream()
	                .map(s -> new LocationAddressDto(s.getId(), s.getName()))
	                .toList();
	    }

}
