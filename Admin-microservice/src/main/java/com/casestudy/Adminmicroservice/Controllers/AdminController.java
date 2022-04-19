package com.casestudy.Adminmicroservice.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Adminmicroservice.Models.Company;
import com.casestudy.Adminmicroservice.Models.User;
import com.casestudy.Adminmicroservice.Services.AdminService;

@RestController
@CrossOrigin(origins ="*")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RestTemplate template;
	
	@RequestMapping("/getusers")
	public List<User> getAllUsers()
	{
		logger.trace("record of all the users");
		return adminService.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public void addUser(@RequestBody User user)
	{
		logger.trace("added the user");
		adminService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
	public void UpdateUser(@RequestBody User user,@PathVariable String id)
	{
		logger.trace("updated the user");
		adminService.UpdateUser(id,user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public void deleteUser(@PathVariable String id)
	{
		logger.trace("deleted the user");
		adminService.deleteUser(id);
	}
	
	// GET COMPANYDETAILS
	
		@RequestMapping("/companydetails")
		public List<Company> getAllCompanyDetails()
		{
			return adminService.getAllCompany();
		}
		
		//CREATE new COMPANYDETAILS
		
		@RequestMapping(method=RequestMethod.POST, value="/companydetails")
		public void createCompany(@RequestBody Company company)
		{
		    adminService.createCompany(company);
		}
		
		//UPDATE COMPANYDETAILS BY ID
		
		@RequestMapping(method=RequestMethod.PUT, value="/companydetails/{id}")
		public void UpdateCompany(@RequestBody Company company,@PathVariable String id)
		{
		   adminService.UpdateCompany(id,company);
		}
		
		//DELETE COMPANYDETAILS BY ID
		
		@RequestMapping(method=RequestMethod.DELETE, value="/companydetails/{id}")
		public void deleteCompany(@PathVariable String id)
		{
		   adminService.deleteCompany(id);
		}
		
		
		//GET COMAPANY DETAILS FROM COMPANY SERVICE(INTERCONNECTION)
		
		@RequestMapping("/company/admin")
		public String getAllCompany()
		{
			String url="http://localhost:8093/company";
			return template.getForObject(url, String.class);
		}
}


