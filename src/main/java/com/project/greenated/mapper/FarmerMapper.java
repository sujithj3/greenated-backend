package com.project.greenated.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.project.greenated.dto.FarmerRequestDto;
import com.project.greenated.dto.FarmerResponseDto;
import com.project.greenated.model.Farmer;

@Mapper(componentModel = "spring")
public interface FarmerMapper {

	@Mapping(source = "countryId", target = "country.countryId")
	@Mapping(source = "stateId", target = "state.stateId")
	@Mapping(source = "userId", target = "user.userId")
	Farmer toEntity(FarmerRequestDto dto);

	void updateEntityFromDto(FarmerRequestDto dto, @MappingTarget Farmer farmer);

	@Mapping(source = "country", target = "country")
	@Mapping(source = "state", target = "state")
	@Mapping(source = "user.userId", target = "userId")
	FarmerResponseDto toDto(Farmer farmer);

	List<FarmerResponseDto> toDtoList(List<Farmer> farmers);

}