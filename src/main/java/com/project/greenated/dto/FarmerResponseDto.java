package com.project.greenated.dto;

import lombok.Data;

@Data
public class FarmerResponseDto {

    private Integer farmerId;
    private String farmerName;
    private String contactNo;
    private Integer userId;
    private FarmerCountryDto country;
    private FarmerStateDto state;
}