package com.blogprojectIO.repositories;

import java.util.List;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogprojectIO.entities.Category;
import com.blogprojectIO.entities.Post;
import com.blogprojectIO.entities.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer>{
	Page<Post> findByUser(User user, Pageable pg);  //fetch all the post for the particualr user
	Page<Post> findByCategory(Category category, Pageable pg); //fetch all the post for the particualr Category
}
