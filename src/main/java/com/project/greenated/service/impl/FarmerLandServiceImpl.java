package com.project.greenated.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.greenated.dto.FarmerLandRequestDto;
import com.project.greenated.dto.FarmerLandResponseDto;
import com.project.greenated.mapper.FarmerLandMapper;
import com.project.greenated.model.Categories;
import com.project.greenated.model.Countries;
import com.project.greenated.model.Farmer;
import com.project.greenated.model.FarmerLand;
import com.project.greenated.model.Location;
import com.project.greenated.model.States;
import com.project.greenated.model.Users;
import com.project.greenated.repository.FarmerLandRepository;
import com.project.greenated.service.FarmerLandService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FarmerLandServiceImpl implements FarmerLandService {

    private final FarmerLandRepository farmerLandRepository;
    private final FarmerLandMapper farmerLandMapper;
    private final EntityManager entityManager;

    @Override
    public FarmerLandResponseDto createLand(FarmerLandRequestDto dto) {

        FarmerLand land = farmerLandMapper.toEntity(dto);
        if (dto.getFarmerId() == null)
            throw new IllegalArgumentException("farmerId is required");

        if (dto.getCategoryId() == null)
            throw new IllegalArgumentException("categoryId is required");

        if (dto.getUserId() == null)
            throw new IllegalArgumentException("userId is required");

        land.setFarmer(entityManager.getReference(Farmer.class, dto.getFarmerId()));
        land.setCategory(entityManager.getReference(Categories.class, dto.getCategoryId()));
        land.setUser(entityManager.getReference(Users.class, dto.getUserId()));

        if (dto.getCountryId() != null)
            land.setCountry(entityManager.getReference(Countries.class, dto.getCountryId()));

        if (dto.getStateId() != null)
            land.setState(entityManager.getReference(States.class, dto.getStateId()));

        if (dto.getDistrictId() != null)
            land.setDistrict(entityManager.getReference(Location.class, dto.getDistrictId()));

        land.setCreatedAt(LocalDateTime.now());

        FarmerLand saved = farmerLandRepository.save(land);
        return farmerLandMapper.toDto(saved);
    }

    @Override
    public FarmerLandResponseDto updateLand(Integer landId, FarmerLandRequestDto dto) {

        FarmerLand land = farmerLandRepository.findById(landId)
                .orElseThrow(() -> new RuntimeException("Farmer land not found"));

        farmerLandMapper.updateEntityFromDto(dto, land);

        if (dto.getFarmerId() != null)
            land.setFarmer(entityManager.getReference(Farmer.class, dto.getFarmerId()));

        if (dto.getCategoryId() != null)
            land.setCategory(entityManager.getReference(Categories.class, dto.getCategoryId()));

        if (dto.getUserId() != null)
            land.setUser(entityManager.getReference(Users.class, dto.getUserId()));

        if (dto.getCountryId() != null)
            land.setCountry(entityManager.getReference(Countries.class, dto.getCountryId()));

        if (dto.getStateId() != null)
            land.setState(entityManager.getReference(States.class, dto.getStateId()));

        if (dto.getDistrictId() != null)
            land.setDistrict(entityManager.getReference(Location.class, dto.getDistrictId()));

        land.setUpdatedAt(LocalDateTime.now());

        return farmerLandMapper.toDto(land);
    }
    @Override
    public List<FarmerLandResponseDto> getLandByUserAndCategory(
            Integer userId, Integer categoryId) {

        List<FarmerLand> lands =
                farmerLandRepository.findByUserAndCategory(userId, categoryId);

        return farmerLandMapper.toDtoList(lands);
    }
}