package com.blogprojectIO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogprojectIO.repositories.UserRepo;

@SpringBootTest
class BlogprojectApplicationTests {
	
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	void checkClass() {
		//how we autowire the interface
		//we autowire the jdk.proxy2.$Proxy99

			
		//use reflector APIs
		System.out.println(this.userRepo.getClass().getName());  //jdk.proxy2.$Proxy99 is the implamentation of UserRepo Immplememtation 
		//created on runtime
		//autowire the class the object hi invoke hota h
		
		//userRepo m jdk.proxy/$Proxy99 class ka pbject aata h
		System.out.println(this.userRepo.getClass().getPackageName());  //jdk.proxy2
	}

}
