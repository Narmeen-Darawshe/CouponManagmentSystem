package com.devtech.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devtech.core.Category;
import com.devtech.core.Coupon;
import com.devtech.core.Customer;
import com.devtech.core.CustomersVsCoupons;
import com.devtech.repository.Customers_vs_CouponsRepository;
import com.devtech.services.CustomerServices;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController extends ClientController{
	

	@Autowired
	 CustomerServices service;
	@Autowired
	Customers_vs_CouponsRepository repo;
	
	 @GetMapping(value="/email")
	    public Set<CustomersVsCoupons> findByEmailAddress(String email){
	    	return repo.findPurchaseByCoustomerID(1);
	    }
	
	@GetMapping(value="/login")	
	public boolean login(@RequestParam String email, @RequestParam String password){
		return service.login(email, password);
	}

	@PostMapping(value="/purchaseCoupon")
	public void purchaseCoupon(@RequestBody Coupon coupon) {
		service.purchaseCoupon(coupon);
	}
	
	@GetMapping(value="/getCustomerCoupons")
	public List<Coupon> getCustomerCoupons() {
		return service.getCustomerCoupons();
	}
	
	
	@GetMapping(value="/getCustomerCouponsByCategory")
	public List<Coupon> getCustomerCoupons(@RequestParam Category category) {
		
		return service.getCustomerCoupons(category);
	}
	
	@GetMapping(value="/getCustomerCouponsByMaxPrice")
	public List<Coupon> getCustomerCoupons(@RequestParam double maxPrice){
		
		return service.getCustomerCoupons(maxPrice);
	}
	
	
	@GetMapping(value="/getCustomerDetails")
	public Optional<Customer> getCustomerDetails() {
		return service.getCustomerDetails();
	}
	
}
