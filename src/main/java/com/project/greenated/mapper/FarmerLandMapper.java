package com.project.greenated.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.project.greenated.dto.FarmerLandRequestDto;
import com.project.greenated.dto.FarmerLandResponseDto;
import com.project.greenated.model.FarmerLand;

@Mapper(componentModel = "spring")
public interface FarmerLandMapper {

	/* ================= CREATE ================= */

	@Mapping(target = "farmer", ignore = true)
	@Mapping(target = "category", ignore = true)
	@Mapping(target = "user", ignore = true)
	@Mapping(target = "country", ignore = true)
	@Mapping(target = "state", ignore = true)
	@Mapping(target = "district", ignore = true)
	FarmerLand toEntity(FarmerLandRequestDto dto);

	/* ================= UPDATE ================= */

	@Mapping(target = "farmer", ignore = true)
	@Mapping(target = "category", ignore = true)
	@Mapping(target = "user", ignore = true)
	@Mapping(target = "country", ignore = true)
	@Mapping(target = "state", ignore = true)
	@Mapping(target = "district", ignore = true)
	void updateEntityFromDto(FarmerLandRequestDto dto, @MappingTarget FarmerLand land);

	/* ================= RESPONSE ================= */

	@Mapping(source = "farmer", target = "farmer")
	@Mapping(source = "category.categoryId", target = "categoryId")
	@Mapping(source = "user.userId", target = "userId")
	@Mapping(source = "country.countryId", target = "countryId")
	@Mapping(source = "state.stateId", target = "stateId")
	@Mapping(source = "district.id", target = "districtId")
	FarmerLandResponseDto toDto(FarmerLand land);

	List<FarmerLandResponseDto> toDtoList(List<FarmerLand> lands);
}
