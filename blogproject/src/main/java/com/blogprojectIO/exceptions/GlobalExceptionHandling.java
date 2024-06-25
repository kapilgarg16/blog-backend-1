package com.blogprojectIO.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


////@RestControllerAdvice is an annotation in Spring Boot that allows you to handle exceptions globally 
//across all controllers in a RESTful web service. It is part of the Spring MVC framework and provides a 
//centralized way to handle exceptions and customize the error response.

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e){
		String msg = e.getMessage();
		ApiResponse apiResponse = new ApiResponse(msg, false);
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
		Map<String, String> resp = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(er -> {
			String field = ((FieldError)er).getField();
			String msg = er.getDefaultMessage();
			resp.put(field, msg);
		});
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}

}
