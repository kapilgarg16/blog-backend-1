package com.blogprojectIO.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogprojectIO.payloads.CategoryDto;
import com.blogprojectIO.payloads.UserDto;
import com.blogprojectIO.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/getall")
	ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto>allCategory = this.categoryService.getAllCategories();
		return new ResponseEntity<List<CategoryDto>>(allCategory, HttpStatus.OK);
	}
	
	@GetMapping("/{catgegoryId}")
	ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer categoryId){
		CategoryDto getCategory = this.categoryService.getCategoryById(categoryId);
		return new ResponseEntity<CategoryDto>(getCategory, HttpStatus.OK);
	}
	
	@PostMapping("/")
	ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto saveCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(saveCategory, HttpStatus.CREATED);	
		}
	
	@PutMapping("/{catgegoryId}")
	ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId)
	{
		CategoryDto category= this.categoryService.updateCategory(categoryDto, categoryId);
		return ResponseEntity.ok(category);
	}
	
	@DeleteMapping("/{catgegoryId}")
	ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId){
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(Map.of("message", "category  deleted successfully"), HttpStatus.OK);
	}
	
	

}
