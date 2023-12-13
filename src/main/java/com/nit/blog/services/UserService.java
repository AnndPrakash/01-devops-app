package com.nit.blog.services;

import java.util.List;

import com.nit.blog.payload.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto>getAllUsers();
	void deleteUser(Integer userId);
	

}
