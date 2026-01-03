package com.project.greenated.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FarmerLandRequestDto {

    private Integer projectId;
    private String projectName;
    private Double landArea;
    private String species;
    private LocalDate plantingDate;

    // REQUIRED
    private Integer farmerId;
    private Integer categoryId;
    private Integer userId;

    private Integer countryId;
    private Integer stateId;
    private Long districtId;

    private Integer status;
}