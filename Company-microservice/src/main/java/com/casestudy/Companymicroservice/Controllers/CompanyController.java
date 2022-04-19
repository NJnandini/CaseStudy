package com.casestudy.Companymicroservice.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Companymicroservice.Models.Company;
import com.casestudy.Companymicroservice.Services.CompanyService;



@RestController
@CrossOrigin(origins= "*")
public class CompanyController {
	
	@Autowired
	private  CompanyService companyService;
	
	@RequestMapping("/company")
	public List<Company> getAllCoupon()
	{
		return companyService.getAllCoupon();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/company")
	public void addCompany(@RequestBody Company company)
	{
		company.setAvailcoupons(companyService.getSequenceNumber(Company.SEQUENCE_NAME));
		companyService.addCoupon(company);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/company/{id}")
	public void UpdateCompany(@RequestBody Company company,@PathVariable int id)
	{
		companyService.UpdateCoupon(id,company);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/company/{id}")
	public void deleteCompany(@PathVariable int id)
	{
		companyService.deleteCoupon(id);
	}
}