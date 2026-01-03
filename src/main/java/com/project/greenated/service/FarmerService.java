package com.project.greenated.service;

import java.util.List;

import com.project.greenated.dto.FarmerRequestDto;
import com.project.greenated.dto.FarmerResponseDto;

public interface FarmerService {

    FarmerResponseDto createFarmer(FarmerRequestDto dto);

    FarmerResponseDto updateFarmer(Integer farmerId, FarmerRequestDto dto);

    List<FarmerResponseDto> getFarmersByUser(Integer userId);
    
  
}
