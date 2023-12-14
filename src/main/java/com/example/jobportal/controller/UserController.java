package com.example.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.requestdto.UserRequestDto;
import com.example.jobportal.service.UserService;
import com.example.jobportal.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService us;
	
	@PostMapping("/users")   // working
	public ResponseEntity<ResponseStructure<String>> inserUser(@RequestBody @Valid UserRequestDto UserRequestDto)
	{
		
		 return us.insertUser(UserRequestDto);
		
	}
}
