package com.casestudy.Companymicroservice.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.Companymicroservice.Models.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, Integer> {
}
