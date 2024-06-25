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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogprojectIO.payloads.PostDto;
import com.blogprojectIO.payloads.PostResponse;
import com.blogprojectIO.payloads.UserDto;
import com.blogprojectIO.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/")
	ResponseEntity<PostDto> addPost(@PathVariable Integer userId, @PathVariable Integer categoryId, @RequestBody PostDto postDto)
	{
		PostDto newPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(newPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userID}/posts")
	ResponseEntity<PostResponse> getAllUserPostsBasedOnTheUser(@PathVariable Integer userId, @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir){
		PostResponse postResponse = this.postService.getAllUserPost(userId, pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}
	
	@GetMapping("/category/{catId}/posts")
	ResponseEntity<PostResponse> getAllPostsBasedOnTheCategory(
			@PathVariable Integer catId, @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir)
	{
		PostResponse postResponse = this.postService.getAllCategoryPost(catId, pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	ResponseEntity<PostDto> getPostUsingPostId(@PathVariable Integer postId)
	{
		PostDto getPost = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(getPost, HttpStatus.OK);
	}
	
	@GetMapping("/getallposts")
	ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir){
		
		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}
	
	@PutMapping("/{postId}")
	ResponseEntity<PostDto> updateUser(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		PostDto updatedPostDto = this.postService.updatePost(postDto, postId);
		return ResponseEntity.ok(updatedPostDto);
	}
	
	
	@DeleteMapping("/{postId}")
	ResponseEntity<?> deletePost(@PathVariable Integer postId){
		this.postService.deletePostById(postId);
		return new ResponseEntity<>(Map.of("message", "post  deleted successfully"), HttpStatus.OK);
	}
	
}
