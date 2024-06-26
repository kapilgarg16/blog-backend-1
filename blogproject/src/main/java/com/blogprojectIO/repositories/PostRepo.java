package com.blogprojectIO.repositories;

import java.util.List;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogprojectIO.entities.Category;
import com.blogprojectIO.entities.Post;
import com.blogprojectIO.entities.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer>{
	Page<Post> findByUser(User user, Pageable pg);  //fetch all the post for the particualr user
	Page<Post> findByCategory(Category category, Pageable pg); //fetch all the post for the particualr Category
	
//    List<Book> findByTitleContaining(String keyword);

    // Alternatively, you can use a custom query
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
    List<Post> searchByTitle(@Param("keyword") String keyword);

//    @Query defines a custom JPQL query. The query string contains a named parameter :keyword.
//    @Param("keyword") binds the method parameter keyword to the named parameter :keyword in the JPQL query.

}
