package com.casestudy.homepage.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.homepage.models.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel ,String> {

	UserModel findByUsername(String username);

	List<UserModel> findByEmail(String email);

	void deleteById(int id);
}
