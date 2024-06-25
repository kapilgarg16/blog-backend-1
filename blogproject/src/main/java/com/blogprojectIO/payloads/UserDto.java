package com.blogprojectIO.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//{
//    "id" : 1,
//    "name" : "kapil",
//    "email" : "kapil.123",
//    "password" : "123",
//    "about" : "21313"
//}


//@NoArgsConstructor
//@Getter
//@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "name should have atlease 4 charcters")
	private String name;
	
	@Email(message = "email should be proper")
	private String email;
	
	@NotEmpty
	@Size(min = 4,message = "password is short")
	@Size(max = 10, message = "password is long")
	private String password;
	
	@NotEmpty
	@Size(min = 10, message = "about is short")
	private String about;

	
	public UserDto() {
		super();
	}


	public UserDto(int id, @NotEmpty @Size(min = 4, message = "name should have atlease 4 charcters") String name,
			@Email(message = "email should be proper") String email,
			@NotEmpty @Size(min = 4, max = 10, message = "password is short") String password,
			@NotEmpty @Size(min = 10, message = "about is short") String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}
	
}
