package com.blogprojectIO.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogprojectIO.entities.User;
import com.blogprojectIO.exceptions.ResourceNotFoundException;
import com.blogprojectIO.payloads.UserDto;
import com.blogprojectIO.repositories.UserRepo;
import com.blogprojectIO.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = this.userDtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		
		return userToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow((() -> new ResourceNotFoundException("user", " Id ", userId)));
		
		// TODO Auto-generated method stub
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		
		User savedUser = this.userRepo.save(user);
		return userToUserDto(savedUser);
		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User getUser = this.userRepo.findById(userId).orElseThrow((() -> new ResourceNotFoundException("user", " Id ", userId)));
		return userToUserDto(getUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User>allUser = this.userRepo.findAll();
		List<UserDto> allUserDto = allUser.stream().map(e->this.userToUserDto(e)).collect(Collectors.toList());
		return allUserDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User getUser = this.userRepo.findById(userId).orElseThrow((() -> new ResourceNotFoundException("user", " Id ", userId)));
		this.userRepo.delete(getUser);
	}
	
	User userDtoToUser(UserDto userDto) {
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
//		user.setName(userDto.getName());
//		user.setPassword(userDto.getPassword());
		

		User user = this.modelMapper.map(userDto, User.class);
		
		return user;
		
	}
	
	UserDto userToUserDto(User user) {
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setAbout(user.getAbout());
//		userDto.setEmail(user.getEmail());
//		userDto.setName(user.getName());
//		userDto.setPassword(user.getPassword());
		
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		return userDto;
		
	}

}
