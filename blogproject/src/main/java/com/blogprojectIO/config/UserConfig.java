package com.blogprojectIO.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
	
	
	@Bean
	public ModelMapper modelMapper(){
		//model mapper is used to mapped the one object with another object
		return new ModelMapper();
	}
	
}
