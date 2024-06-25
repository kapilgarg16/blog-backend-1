package com.blogprojectIO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogprojectIO.entities.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
