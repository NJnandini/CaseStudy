package com.casestudy.Adminmicroservice.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="user")
public class Customer  {

//USER ID AUTOMATIC GENERATED
	
@Id
private String id;
//USER NAME

private String name;

//USER PASSWORD

private String password;

//USER EMAIL

private String email;
//EMPTY CONSTRUCTOR
public Customer()
{
	
}
/*
 * SETTERS AND GETTERS
 */
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
	return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
}
	
    public Customer(String name, String password, String email) {
    
		this.name = name;
		this.password = password;
		this.email = email;
	}
}
