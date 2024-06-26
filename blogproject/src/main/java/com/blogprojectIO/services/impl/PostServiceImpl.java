package com.blogprojectIO.services.impl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;

//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blogprojectIO.entities.Category;
import com.blogprojectIO.entities.Post;
import com.blogprojectIO.entities.User;
import com.blogprojectIO.exceptions.ResourceNotFoundException;
import com.blogprojectIO.payloads.PostDto;
import com.blogprojectIO.payloads.PostResponse;
import com.blogprojectIO.repositories.CategoryRepo;
import com.blogprojectIO.repositories.PostRepo;
import com.blogprojectIO.repositories.UserRepo;
import com.blogprojectIO.services.PostService;

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
		Post post = this.postRepo.findById(postId).orElseThrow((() -> new ResourceNotFoundException("post", " Id ", postId)));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		
		Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow((() -> new ResourceNotFoundException("post", " Id ", postId)));
		PostDto postDto = this.modelMapper.map(post, PostDto.class);
		// TODO Auto-generated method stub
		return postDto;
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir){
		Sort sort = null;
		if(sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		}
		else {
			sort = Sort.by(sortBy).descending();
		}
		Pageable pg = PageRequest.of(pageNumber, pageSize, sort);
		
		Page<Post>pagePost = this.postRepo.findAll(pg);
		List<Post>listOfPosts = pagePost.getContent();
		List<PostDto>listOfPostDto = listOfPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(listOfPostDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;
	}

	@Override
	public PostResponse getAllUserPost(Integer userId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		
		User user = this.userRepo.findById(userId).orElseThrow((() -> new ResourceNotFoundException("user", " Id ", userId)));
		
		Sort sort = null;
		if(sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		}
		else {
			sort = Sort.by(sortBy).descending();
		}
		Pageable pg = PageRequest.of(pageNumber, pageSize, sort);
		
		Page<Post>pagePost =  this.postRepo.findByUser(user,pg);
		List<Post>listOfPosts =  pagePost.getContent();
		List<PostDto>listOfPostDto = listOfPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(listOfPostDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;

	}

	@Override
	public PostResponse getAllCategoryPost(Integer categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryID", categoryId));
		Sort sort = null;
		if(sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		}
		else {
			sort = Sort.by(sortBy).descending();
		}
		Pageable pg = PageRequest.of(pageNumber, pageSize, sort);
		Page<Post>pagePost = this.postRepo.findByCategory(cat, pg);
		List<Post>listOfPosts =  pagePost.getContent();
		List<PostDto>listOfPostDto = listOfPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(listOfPostDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;
	}

	@Override
	public void deletePostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow((() -> new ResourceNotFoundException("post", " Id ", postId)));
		this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		List<Post>listOfPosts = this.postRepo.searchByTitle(keyword);
		List<PostDto>listOfPostDto = listOfPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return listOfPostDto;
	}


}
