package com.casestudy.Companymicroservice.Models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection="coupon")
public class Coupons {
	
	private String code;   //amazoncode orflipkart code
	private  String discount;  //50%  or based on users
	private  String expDate;   //date 
	
	public Coupons() {}
	
	public Coupons(String code, String discount, String expDate) {
		super();
		this.code = code;
		this.discount = discount;
		this.expDate = expDate;
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Coupon [code=" + code + ", discount=" + discount + ", expDate=" + expDate + "]";
	}



}

