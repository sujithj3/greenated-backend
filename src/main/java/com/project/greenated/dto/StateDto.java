package com.project.greenated.dto;

import java.util.List;

import lombok.Data;

@Data
public class StateDto {
    private Integer id;
    private String name;
    private List<DistrictDto> districts;
}