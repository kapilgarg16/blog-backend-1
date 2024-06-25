package com.blogprojectIO.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogprojectIO.payloads.CategoryDto;
import com.blogprojectIO.payloads.UserDto;

@Service
public interface CategoryService {
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	CategoryDto getCategoryById(Integer categoryId);
	List<CategoryDto> getAllCategories();
	void deleteCategory(Integer CategoryDto);

}
