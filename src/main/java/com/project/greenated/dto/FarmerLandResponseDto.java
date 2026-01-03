package com.project.greenated.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FarmerLandResponseDto {

    private Integer landId;
    private Integer projectId;
    private String projectName;
    private Double landArea;
    private String species;
    private LocalDate plantingDate;

    private FarmerResponseDto farmer;
    private Integer categoryId;
    private Integer userId;

    private Integer countryId;
    private Integer stateId;
    private Long districtId;

    private Integer status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
