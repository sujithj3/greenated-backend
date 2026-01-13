package com.project.greenated.service;

import java.util.List;

import com.project.greenated.dto.AddressDto;
import com.project.greenated.dto.LocationAddressDto;

public interface LocationService {
	List<AddressDto> getAllCountries();
    List<AddressDto> getStatesByCountry(Integer countryId);
    
    List<LocationAddressDto>getDistrictByState(Integer stateId);
}
