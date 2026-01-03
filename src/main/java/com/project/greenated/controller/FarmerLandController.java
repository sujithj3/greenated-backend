package com.project.greenated.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.greenated.dto.FarmerLandRequestDto;
import com.project.greenated.dto.FarmerLandResponseDto;
import com.project.greenated.dto.ResponseDto;
import com.project.greenated.service.FarmerLandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/farmer-land")
@RequiredArgsConstructor
@CrossOrigin
public class FarmerLandController {

    private final FarmerLandService farmerLandService;

    @PostMapping("/create")
    public ResponseDto createLand(@RequestBody FarmerLandRequestDto dto) {
        try {
            FarmerLandResponseDto response = farmerLandService.createLand(dto);
            return new ResponseDto(false, 200, "Land created successfully", response);
        } catch (Exception e) {
            return new ResponseDto(true, 500, "Failed to create land", e.getMessage());
        }
    }

    @PutMapping("/edit/{landId}")
    public ResponseDto updateLand(
            @PathVariable Integer landId,
            @RequestBody FarmerLandRequestDto dto) {

        try {
            FarmerLandResponseDto response =
                    farmerLandService.updateLand(landId, dto);
            return new ResponseDto(false, 200, "Land updated successfully", response);
        } catch (Exception e) {
            return new ResponseDto(true, 500, "Failed to update land", e.getMessage());
        }
    }

    @GetMapping("/get/user/{userId}/category/{categoryId}")
    public ResponseDto getLandByUserAndCategory(
            @PathVariable Integer userId,
            @PathVariable Integer categoryId) {

        try {
            List<FarmerLandResponseDto> response =
                    farmerLandService.getLandByUserAndCategory(userId, categoryId);
            return new ResponseDto(false, 200, "Data fetched successfully", response);
        } catch (Exception e) {
            return new ResponseDto(true, 500, "Failed to fetch land", e.getMessage());
        }
    }
}

