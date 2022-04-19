package com.casestudy.Companymicroservice.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import com.casestudy.Companymicroservice.Models.Company;
import com.casestudy.Companymicroservice.Models.Coupons_Sequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import com.casestudy.Companymicroservice.Repositories.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	public CompanyService(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}


	public int getSequenceNumber(String sequenceName) {
		//get sequence no
		Query query = new Query(Criteria.where("availcoupons").is(sequenceName));
		//update the sequence no
		Update update = new Update().inc("seq", 1);
		//modify in document
		Coupons_Sequence counter = mongoOperations
				.findAndModify(query,
						update, options().returnNew(true).upsert(true),
						Coupons_Sequence.class);

		return (!Objects.isNull(counter) ? counter.getSeq() : 1);
	}

	public List<Company> getAllCoupon()
	{
		List<Company> company=new ArrayList<>();
		companyRepository.findAll()
		.forEach(company::add);
		return company;
	}

	public void addCoupon(Company company)

	{
		companyRepository.save(company);
	}
	public void UpdateCoupon(int id, Company company) {
		companyRepository.save(company);

	}
	public void deleteCoupon(int id) {
		companyRepository.deleteById(id);
	}
	
}
