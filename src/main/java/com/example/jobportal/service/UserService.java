package com.example.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobportal.entity.User;
import com.example.jobportal.repository.UserRepository;
import com.example.jobportal.requestdto.UserRequestDto;
import com.example.jobportal.responsedto.UserResponseDto;
import com.example.jobportal.utility.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class UserService {

	@Autowired
	UserRepository ur;
	

	private User convertToUser(UserRequestDto userRq, User user)
	{
		user.setUsername(userRq.getUsername());
		user.setEmail(userRq.getEmail());
		user.setPassword(userRq.getPassword());
		user.setUserRole(userRq.getUserrole());
		return user;
	}


	private UserResponseDto convertToUserResponse (User user)
	{
		UserResponseDto ur = new UserResponseDto();
		
		ur.setUserId(user.getUserId());
		ur.setUserName(user.getUsername());
		ur.setEmail(user.getEmail());
		return ur;
	}
	
	public ResponseEntity<ResponseStructure<String>> insertUser(@Valid UserRequestDto userRequestDto) {
		
		User user = convertToUser(userRequestDto ,new User());
		ur.save(user);
		
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage(" User data saved successfully");
		rs.setData(" 1 USER ADDED  SUCCESSFULLY");
		
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.CREATED);	
		
	}

}
