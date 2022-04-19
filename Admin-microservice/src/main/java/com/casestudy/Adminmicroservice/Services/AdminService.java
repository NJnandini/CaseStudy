package com.casestudy.Adminmicroservice.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Adminmicroservice.Models.Company;
import com.casestudy.Adminmicroservice.Models.User;
import com.casestudy.Adminmicroservice.Repositories.CompanyRepository;
import com.casestudy.Adminmicroservice.Repositories.UserRepository;

@Service
public class AdminService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository  companyRepository;
	
	public List<User> getAllUsers()
	{
		List<User> users=new ArrayList<>();
		userRepository.findAll()
		.forEach(users::add);
		return users;
	}
	
	public void addUser(User user)
	{
		userRepository.save(user);
	}
	
	public void UpdateUser(String id, User user) 
	{
		userRepository.save(user);	
	}
	
	public void deleteUser(String id) 
	{
	userRepository.deleteById(id);	
	}
	
	public List<Company> getAllCompany()
	{
		List<Company> companies=new ArrayList<>();
		companyRepository.findAll()
		.forEach(companies::add);
		return companies;
	}

	public void createCompany(Company company)

	{
		companyRepository.save(company);
	}
	
	public void UpdateCompany(String id, Company company) {
		companyRepository.save(company);

	}
	
	public void deleteCompany(String id) {
		companyRepository.deleteById(id);

	}

}
