package com.project.greenated.service;

import java.util.List;

import com.project.greenated.dto.CategoryDto;

public interface CategoryService {
	public List<CategoryDto>getDepartmentCategory();
	
	public List<CategoryDto>getDepartmentSubCategory(Integer parentId);
	
	public CategoryDto addCategory(CategoryDto categoryDto);
	
	public CategoryDto updateCategory(CategoryDto categoryDto);
}
