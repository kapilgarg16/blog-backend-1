package com.blogprojectIO.payloads;

import java.sql.Date;
import java.time.LocalDate;

import com.blogprojectIO.entities.Category;
import com.blogprojectIO.entities.User;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PostDto {
	
	private Integer postId;
	
	@NotEmpty
	@Size(min = 5,message = "length is too short")
	private String title;
	
	@NotEmpty
	@Size(min = 10,message = "length is too short")
	private String content;
	
	private String imageName;
	
	private Date currentDate;
	
	private Category category;
	
	private User user;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
