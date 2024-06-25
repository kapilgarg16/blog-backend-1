package com.blogprojectIO.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogprojectIO.entities.User;
import com.blogprojectIO.payloads.UserDto;
import com.blogprojectIO.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//getalluser
	//getsingleuser
	//update
	//post
	//delete
	
	@GetMapping("/getall")
	ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto>allUsers = this.userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(allUsers, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		UserDto getUser = this.userService.getUserById(userId);
		return new ResponseEntity<UserDto>(getUser, HttpStatus.OK);
	}
	
	@PostMapping("/")
	ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto){
		UserDto saveUser = this.userService.createUser(userDto);
		return new ResponseEntity<UserDto>(saveUser, HttpStatus.CREATED);	
		}
	
	@PutMapping("/{userId}")
	ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId)
	{
		UserDto user= this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{userId}")
	ResponseEntity<?> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<>(Map.of("message", "user deleted successfully"), HttpStatus.OK);
	}
	
}
