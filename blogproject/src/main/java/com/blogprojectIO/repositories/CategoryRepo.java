package com.blogprojectIO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogprojectIO.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
