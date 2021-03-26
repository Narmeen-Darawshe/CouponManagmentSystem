package com.devtech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devtech.core.Company;
import com.devtech.core.Customer;
import com.devtech.services.AdminServices;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController extends ClientController  {

	@Autowired
	AdminServices service;
	
	
	
/*@RequestMapping(value = "/exx", method = RequestMethod.GET)
	@ResponseBody
	public String getBarBySimplePathWithRequestParam(
	  @RequestParam("id") long id) {
	    return "Get a specific Bar with id=" + id;
	    
	}
	
	@RequestMapping(value = "/ex/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePathWithPathVariable(
	  @PathVariable("id") long id) {
	    return "Get a specific Foo with id=" + id;
	}
	*/
	
	
	@GetMapping(value="/login")	
	public  boolean login(@RequestParam String email, @RequestParam String password) {
		
		return service.login(email, password);
		
	}


	
	
	@PostMapping(value="/addCompany")	
	public void addCompany( @RequestBody Company company) {
		service.addCompany(company);
	}

	
	
	@PutMapping(value="/updateCompany")	
	public void updateCompany(@RequestBody Company company){
		service.updateCompany(company);
	}
	
	
	
	@DeleteMapping(value="/deleteCompany")	
	public void deleteCompany(@RequestParam int companyID) {
		service.deleteCompany(companyID);
	}
	
	
	
    @GetMapping(value="/getAllCompanies")
	public List<Company> getAllCompanies() {
		return service.getAllCompanies();
	}
    
    
    
    
    @GetMapping("/getOneCompany")
    public List<Company> getOneCompany(@RequestParam int companyID) {
    	
    	return service.findCompanyById(companyID);
    }
    
    
    @PostMapping(value="/addCustomer")
    public void addCustomer(@RequestBody Customer customer) {
    	service.addCustomer(customer);
    }
    
    
    
    @PutMapping(value="/updateCustomer")	
    public void updateCustomer(@RequestBody Customer customer) {
    	service.updateCustomer(customer);
    }
    
    
    
    
    @DeleteMapping(value="/deleteCustomer")	
    public void deleteCustomer(@RequestParam int customerID) {
    	
    	service.deleteCustomer(customerID);
    }
    
    
    @GetMapping(value="/getAllCustomers")
    public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
    	
    }
    
  /*  
	@RequestMapping(value="/test", method=RequestMethod.GET)
	  public @ResponseBody String test() {
	      return "InboxController.test() - I'm OK ! ! helloStr";
}
	

	
    @GetMapping(value="/email")
    public  List<Company> findByEmailAddress(String email){
    	return service.findByEmail(email);
    }*/
    
   
    
    @GetMapping("/getOneCustomer")
    public Optional<Customer> getOneCustomer(@RequestParam int customerID) {
    	return service.getOneCustomer(customerID);
    }

}
