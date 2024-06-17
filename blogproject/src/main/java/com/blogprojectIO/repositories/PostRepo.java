package com.blogprojectIO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogprojectIO.entities.Category;
import com.blogprojectIO.entities.Post;
import com.blogprojectIO.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);  //fetch all the post for the particualr user
	List<Category>findByCategory(Category category); //fetch all the post for the particualr Category
}
