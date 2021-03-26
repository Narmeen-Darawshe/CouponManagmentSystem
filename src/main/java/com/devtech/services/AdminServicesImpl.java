package com.devtech.services;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.devtech.core.Company;
import com.devtech.core.Coupon;
import com.devtech.core.Customer;
import com.devtech.repository.CompanyRepository;
import com.devtech.repository.CouponRepository;
import com.devtech.repository.CustomerRepository;


@Service
public class AdminServicesImpl extends ClientServices implements AdminServices {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	
	
public AdminServicesImpl(CompanyRepository companyRepository, CouponRepository couponRepository,
			CustomerRepository customerRepository) {
		super();
		this.companyRepository = companyRepository;
		this.couponRepository = couponRepository;
		this.customerRepository = customerRepository;
	}


	public boolean login(String email, String password) {
		
    if (email.equals("admin@admin.com") & password.equals("Admin")) {
			
			return true;
			
		}else return false;
		
	
	}

	
	//**************************************************************************add new company**********************************************************************	
	@Override 
	public void addCompany(Company company) {
		 
	
		System.out.println(companyRepository.findByEmail(company.getEmail()));
		  	 if (companyRepository.findByEmail(company.getEmail()).isEmpty() & companyRepository.findByName(company.getName()).isEmpty()) {
		  		  companyRepository.save(company);
		  		  
		  	}else System.out.println("Company already exists");
		
	 }
	


	//**************************************************************************update company info**********************************************************************
	 public void updateCompany(Company company){
		 
		if( companyRepository.existsById(company.getId())) {
			
			companyRepository.updateCompany(company.getEmail(), company.getPassword(), company.getId());
		}

	 }
	 
	 
	//**************************************************************************delete company**********************************************************************
	public void deleteCompany(int companyID) {
		 
		 int couponID;

	     List<Coupon> CouponList = couponRepository.findByCompanyID(companyID);
	     
	     if( companyRepository.existsById(companyID)) {
	    Iterator<Coupon> itr=CouponList.iterator(); 
	     while(itr.hasNext()){  
	    	    Coupon coupon=(Coupon)itr.next();  
	    	   couponID=coupon.getId(); 
	    	   couponRepository.deleteCouponPurchase(couponID);
	    	   couponRepository.deleteById(couponID);
	    	    
	    	  }  
	     companyRepository.deleteById(companyID);
	     }else System.out.println("Company already exists"); 
	 
	 }
	 
	//**************************************************************************print all companies info**********************************************************************	 
	  public List<Company> getAllCompanies() {

		  return (List<Company>) companyRepository.findAll();
	 }
	 
	 
	//**************************************************************************print one company info**********************************************************************	 
	  
	  public List<Company> findCompanyById(int companyID) {

		 return companyRepository.findById(companyID);
	 }
	 
	 
	 
	//**************************************************************************add a new customer**********************************************************************	 
	public void addCustomer(Customer customer) {
		 
		
		 if (customerRepository.findByEmail(customer.getEmail()).isEmpty()) {
	  		
			 customerRepository.save(customer);
			 }else System.out.println("Customer already exists");
			
		 }
		 
	 
	 
	//**************************************************************************update customer**********************************************************************	 
	 public void updateCustomer(Customer customer) {

		 

	   if (customerRepository.existsById(customer.getId())  ) {
	  		 
			customerRepository.updateCustomer(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPassword(), customer.getId());
			 
			 
			 }else System.out.println("Customer does not exists");
			
		 }
		 
	 
	//**************************************************************************delete customer**********************************************************************	 
	 public void deleteCustomer(int customerID) {
		 

		 if (customerRepository.existsById(customerID)  ) {
	  		 
			couponRepository.deleteCouponPurchaseByCustomerID(customerID);
			customerRepository.deleteById(customerID);
			
			 }else System.out.println("Customer does not exists");
			
		 }
		
	//**************************************************************************print all customers**********************************************************************	 
	 public List<Customer> getAllCustomers() {
		 
		 return (List<Customer>) customerRepository.findAll();
		 
		 
		 
	 }
	//**************************************************************************print one customer*******************************************************	 
     public Optional<Customer> getOneCustomer(int customerID){
		
    	 if (customerRepository.existsById(customerID)  ) {
		
	  		 return customerRepository.findById(customerID);
			
			 }else System.out.println("Customer does not exists");{
		    return null;
		    }
		 
    	 }
		 
		 
			
		
 

	
}
