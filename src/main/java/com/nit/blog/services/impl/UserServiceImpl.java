package com.nit.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.blog.entity.User;
import com.nit.blog.exception.ResourceNotFoundException;
import com.nit.blog.payload.UserDto;
import com.nit.blog.repository.UserRepository;
import com.nit.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepository.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setName(userDto.getName());
		user.setPasword(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setId(userDto.getId());
		User updatedUser = this.userRepository.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> userDto = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		this.userRepository.delete(user);
	}

	public User dtoToUser(UserDto userDto) {
		User user=this.mapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setEmail(userDto.getEmail());
//		user.setName(userDto.getName());
//		user.setPasword(userDto.getPasword());
//		user.setAbout(userDto.getAbout());
		return user;

	}

	public UserDto userToDto(User user) {
		UserDto userDto = this.mapper.map(user, UserDto.class);
		return userDto;
	}

}
