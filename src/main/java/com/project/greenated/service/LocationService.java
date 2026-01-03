package com.project.greenated.service;

import java.util.List;

import com.project.greenated.dto.AddressDto;

public interface LocationService {
	List<AddressDto> getAllCountries();
    List<AddressDto> getStatesByCountry(Long countryId);
}
