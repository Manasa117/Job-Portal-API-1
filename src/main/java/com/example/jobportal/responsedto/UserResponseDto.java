package com.example.jobportal.responsedto;

import org.springframework.stereotype.Component;

@Component
public class UserResponseDto {

	   private  int userId;
	   private  String userName;
	   private  String email;
	   
	   
	   
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserResponseDto [userId=" + userId + ", userName=" + userName + ", email=" + email + "]";
	}
	   
	   
}
