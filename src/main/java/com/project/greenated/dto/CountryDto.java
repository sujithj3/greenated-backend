package com.project.greenated.dto;

import java.util.List;

import lombok.Data;

@Data
public class CountryDto {
    private Integer id;
    private String name;
    private List<StateDto> states;
}