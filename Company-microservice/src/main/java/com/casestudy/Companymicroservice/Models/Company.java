package com.casestudy.Companymicroservice.Models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.stereotype.Component;

@Component
@Document(collection="company")
public class Company {

	//GENERATE AUTO SEQUENCE FOR AVAILCOUPONS

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	//GENERATE AUTO OBJECTID 

	@Id 
	ObjectId databaseid;
	

	//AVAILABLE COUPONS 
	private int  availcoupons; 

	//COMPANY NAME
	private  String comname;

	//LIST OF CATEGORIES CLASS
	private  List<Categories> categories;

	//LIST OF COUPONS CLASS
	private List<Coupons> coupon;

	/*
	 *GETTERS AND SETTERS
	 */
	
	public int getAvailcoupons() {
		return availcoupons;
	}


	public void setAvailcoupons(int availcoupons) {
		this.availcoupons = availcoupons;
	}


	public String getComname() {
		return comname;
	}


	public void setComname(String comname) {
		this.comname = comname;
	}


	public List<Categories> getCategories() {
		return categories;
	}


	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}


	public List<Coupons> getCoupon() {
		return coupon;
	}


	public void setCoupon(List<Coupons> coupon) {
		this.coupon = coupon;
	}


	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}


	public Company(String comname, List<Categories> categories, List<Coupons> coupon) {

		this.comname = comname;
		this.categories = categories;
		this.coupon = coupon;
	}


	public Company() {

	}


	@Override
	public String toString() {
		return "Company [availcoupons=" + availcoupons + ", comname=" + comname + ", categories="
				+ categories + ", coupon=" + coupon + "]";
	}


}