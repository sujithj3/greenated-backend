package com.project.greenated.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.project.greenated.dto.CategoryDto;
import com.project.greenated.model.Categories;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    
    @Mapping(target = "parentId", source = "parentId.categoryId")
    CategoryDto toDto(Categories entity);

    List<CategoryDto> toDtoList(List<Categories> entities);

   
    @Mapping(target = "parentId", source = "parentId")
    Categories toEntity(CategoryDto dto);

    
    @Mapping(target = "parentId", ignore = true)
    void updateEntityFromDto(CategoryDto dto, @MappingTarget Categories entity);

    
    default Categories map(Integer parentId) {
        if (parentId == null) {
            return null;
        }
        Categories parent = new Categories();
        parent.setCategoryId(parentId);
        return parent;
    }
}

