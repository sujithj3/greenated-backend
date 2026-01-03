package com.project.greenated.service;

import java.util.List;

import com.project.greenated.dto.FarmerLandRequestDto;
import com.project.greenated.dto.FarmerLandResponseDto;

public interface FarmerLandService {

    FarmerLandResponseDto createLand(FarmerLandRequestDto dto);

    FarmerLandResponseDto updateLand(Integer landId, FarmerLandRequestDto dto);

    List<FarmerLandResponseDto> getLandByUserAndCategory(
            Integer userId, Integer categoryId);
}

