package com.project.greenated.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.greenated.dto.FarmerRequestDto;
import com.project.greenated.dto.FarmerResponseDto;
import com.project.greenated.mapper.FarmerLandMapper;
import com.project.greenated.mapper.FarmerMapper;
import com.project.greenated.model.Farmer;
import com.project.greenated.repository.FarmerLandRepository;
import com.project.greenated.repository.FarmersRepository;
import com.project.greenated.service.FarmerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FarmerServiceImpl implements FarmerService {
    @Autowired
	private  FarmersRepository farmerRepository;
    
    @Autowired
   	private  FarmerLandRepository repository;
    @Autowired
    private  FarmerMapper farmerMapper;
    
    @Autowired
    private  FarmerLandMapper mapper;

    @Override
    public FarmerResponseDto createFarmer(FarmerRequestDto dto) {
        Farmer farmer = farmerMapper.toEntity(dto);   
        Farmer saved = farmerRepository.save(farmer);
        return farmerMapper.toDto(saved);
    }

    @Override
    public FarmerResponseDto updateFarmer(Integer farmerId, FarmerRequestDto dto) {
        Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
        farmerMapper.updateEntityFromDto(dto, farmer);
        Farmer updatedCategory = farmerRepository.save(farmer);
	    return farmerMapper.toDto(updatedCategory);
    }

    @Override
    public List<FarmerResponseDto> getFarmersByUser(Integer userId) {
        List<Farmer> farmers =
                farmerRepository.findFarmersByUserAndParent(userId);
        return farmerMapper.toDtoList(farmers);
    }
    
}
