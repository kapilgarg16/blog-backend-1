package com.blogprojectIO.services.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogprojectIO.entities.Category;
import com.blogprojectIO.entities.Post;
import com.blogprojectIO.entities.User;
import com.blogprojectIO.exceptions.ResourceNotFoundException;
import com.blogprojectIO.payloads.PostDto;
import com.blogprojectIO.payloads.UserDto;
import com.blogprojectIO.repositories.CategoryRepo;
import com.blogprojectIO.repositories.PostRepo;
import com.blogprojectIO.repositories.UserRepo;
import com.blogprojectIO.services.PostService;
import com.blogprojectIO.services.UserService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		//get user by userId
		//getCategoryBycategoryId
		//get data;
		Post post = this.modelMapper.map(postDto, Post.class);
		User user = this.userRepo.findById(userId).orElseThrow((() -> new ResourceNotFoundException("user", " Id ", userId)));
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryID", categoryId));
		
		
		post.setUser(user);
		post.setCategory(category);
		post.setCurrentDate(new Date(1));
		post.setImageName("display.img");
		
		Post newPost = this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllUserPost(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllCategoryPost(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePostById(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


}
