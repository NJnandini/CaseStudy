package com.casestudy.Adminmicroservice.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.Adminmicroservice.Models.Company;



@Repository
public interface CompanyRepository extends MongoRepository<Company,String> {

}

