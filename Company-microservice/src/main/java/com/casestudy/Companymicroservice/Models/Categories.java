package com.casestudy.Companymicroservice.Models;

import java.util.List;


public class Categories {    //categories

	private  String name;     //accessories,Mobiles e.t.c 
	private  String description;   
	private  List<String> details;//

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setPrice(List<String> details) {
		this.details = details;
	}
	public Categories(String name, String description, List<String> details) {

		this.name = name;
		this.description = description;
		this.details = details;
	}
	@Override
	public String toString() {
		return "Categories [name=" + name + ", description=" + description + ", details=" + details + "]";
	}
	public Categories() {

	}

}
