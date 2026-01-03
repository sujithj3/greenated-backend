package com.project.greenated.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.greenated.dto.CategoryDto;
import com.project.greenated.dto.ResponseDto;
import com.project.greenated.service.CategoryService;

@RestController
@CrossOrigin
public class CategoryController {
	
	@Value("${code.success}") 
	private int successCode;

	@Value("${code.fail}")
	private int failCode;

	@Value("${code.error.bad-request}")
	private int badRequestCode;	

	@Value("${code.error.service-error}")
	private int serviceErrorCode;

	@Value("${message.success}")
	private String successMsg;

	@Value("${message.fail}")
	private String failMsg;

	@Value("${message.error.bad-request}")
	private String badRequestMsg;

	@Value("${message.error.service-error}")
	private String serviceErrorMsg;

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save/category")
	public ResponseDto saveCategory(@RequestBody CategoryDto categoryDto) {
		try {
			CategoryDto response = categoryService.addCategory(categoryDto);
			return new ResponseDto(false, successCode, successMsg, response);
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
	}

	@GetMapping("/get/categorylist")
	public ResponseDto getCategoryList() {

		try {
			List<CategoryDto> response = categoryService.getDepartmentCategory();
			return new ResponseDto(false, successCode, successMsg, response);
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
	}
	
	@GetMapping("/get/subcategorylist/{parentId}")
	public ResponseDto getSubCategoryList(@PathVariable Integer parentId ) {

		try {
			List<CategoryDto> response = categoryService.getDepartmentSubCategory(parentId);
			return new ResponseDto(false, successCode, successMsg, response);
		} catch (Exception e) {
			return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
		}
	}
	@PostMapping("/edit/category/{categoryId}")
	public ResponseDto updateCategories(
	        @PathVariable Integer categoryId,
	        @RequestBody CategoryDto categoryDto
	) {
	    try {
	        categoryDto.setCategoryId(categoryId);
	        CategoryDto response = categoryService.updateCategory(categoryDto);
	        return new ResponseDto(false, successCode, successMsg, response);
	    } catch (Exception e) {
	        return new ResponseDto(true, serviceErrorCode, serviceErrorMsg, e.getMessage());
	    }
	}
}
