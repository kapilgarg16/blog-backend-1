package com.blogprojectIO.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogprojectIO.entities.Post;
import com.blogprojectIO.payloads.PostDto;

@Service
public interface PostService {
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	PostDto updatePost(PostDto postDto, Integer postId);
	PostDto getPostById(Integer postId);
	List<PostDto> getAllPost();
	List<PostDto> getAllUserPost(Integer postId);
	List<PostDto> getAllCategoryPost(Integer categoryId);
	void deletePostById(Integer postId);
	List<PostDto> searchPost(String keyword);
}
