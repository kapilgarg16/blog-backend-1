package com.blogprojectIO.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogprojectIO.payloads.PostDto;
import com.blogprojectIO.services.PostService;

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
}
