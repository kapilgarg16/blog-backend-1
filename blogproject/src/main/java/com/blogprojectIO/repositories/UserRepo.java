package com.blogprojectIO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogprojectIO.entities.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
