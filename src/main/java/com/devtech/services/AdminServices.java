package com.devtech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devtech.core.Company;
import com.devtech.core.Customer;


public interface AdminServices {

	

	public boolean login(String email, String password);
	 public void addCompany(Company company);
	 public void updateCompany(Company company);
	 public void deleteCompany(int companyID);
	 public List<Company> getAllCompanies();
	 public List<Company> findCompanyById(int companyID);
	 public void addCustomer(Customer customer);
	 public void updateCustomer(Customer customer);
	 public void deleteCustomer(int customerID);
	 public List<Customer> getAllCustomers();
	 public Optional<Customer> getOneCustomer(int customerID);
	 




	
}
