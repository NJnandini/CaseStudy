package com.casestudy.Adminmicroservice.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.Adminmicroservice.Models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
