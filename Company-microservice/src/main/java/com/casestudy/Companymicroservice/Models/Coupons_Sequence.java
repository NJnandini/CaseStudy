package com.casestudy.Companymicroservice.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection="coupon-sequence")
@Component
public class Coupons_Sequence {
	@Id 
	private int id;

	private int seq;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public Coupons_Sequence() {

	}



}
