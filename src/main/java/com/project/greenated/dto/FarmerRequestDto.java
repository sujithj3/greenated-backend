package com.project.greenated.dto;

import lombok.Data;

@Data
public class FarmerRequestDto {

    private String farmerName;
    private String contactNo;
    private Integer userId; 
    private Integer stateId;
    private Integer countryId;
}