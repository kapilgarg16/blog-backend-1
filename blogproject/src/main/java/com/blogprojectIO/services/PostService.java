package com.blogprojectIO.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogprojectIO.entities.Post;
import com.blogprojectIO.payloads.PostDto;
import com.blogprojectIO.payloads.PostResponse;

@Service
public interface PostService {
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	PostDto updatePost(PostDto postDto, Integer postId);
	PostDto getPostById(Integer postId);
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	PostResponse getAllUserPost(Integer userId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	PostResponse getAllCategoryPost(Integer categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	void deletePostById(Integer postId);
	List<PostDto> searchPost(String keyword);
}
