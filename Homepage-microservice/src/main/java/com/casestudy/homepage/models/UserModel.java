package com.casestudy.homepage.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "user")
public class UserModel {

	@Id
	private String id;
	
	private String username;
	private String password;
	private String email;
	
	public UserModel()
	{
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return String.format("User[id='%s',username='%s',password='%s',email='%s']",id,username,password,email);
	}

}
