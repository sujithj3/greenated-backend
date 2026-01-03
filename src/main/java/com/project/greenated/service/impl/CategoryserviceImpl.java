package com.project.greenated.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.greenated.dto.CategoryDto;
import com.project.greenated.mapper.CategoryMapper;
import com.project.greenated.model.Categories;
import com.project.greenated.repository.CategoriesRepository;
import com.project.greenated.service.CategoryService;
@Service
public class CategoryserviceImpl implements CategoryService{
	@Autowired 
	private CategoriesRepository categoryRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<CategoryDto> getDepartmentCategory() {
	    return categoryMapper.toDtoList(categoryRepository.getMainCategories());
	}
	
	
	@Override
	public List<CategoryDto>getDepartmentSubCategory(Integer parentId){
		return categoryMapper.toDtoList(categoryRepository.getSubCategories(parentId));
	}
    
	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
	    Categories entity = categoryMapper.toEntity(categoryDto);
	    Categories savedEntity = categoryRepository.save(entity);
	    return categoryMapper.toDto(savedEntity);
	}
	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto) {
	    Categories existingCategory = categoryRepository.findById(categoryDto.getCategoryId())
	            .orElseThrow(() -> new RuntimeException("Category not found"));
	    categoryMapper.updateEntityFromDto(categoryDto, existingCategory);
	    Categories updatedCategory = categoryRepository.save(existingCategory);
	    return categoryMapper.toDto(updatedCategory);
	}
}
