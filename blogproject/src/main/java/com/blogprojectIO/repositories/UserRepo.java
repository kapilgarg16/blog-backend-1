package com.blogprojectIO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogprojectIO.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
