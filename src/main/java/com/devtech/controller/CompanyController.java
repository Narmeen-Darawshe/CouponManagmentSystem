package com.devtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devtech.core.Category;
import com.devtech.core.Company;
import com.devtech.core.Coupon;
import com.devtech.services.CompanyServices;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/company")
public class CompanyController extends ClientController{

	@Autowired
	CompanyServices service;
	
	
	
	@GetMapping(value="/login")	
	public boolean login(@RequestParam String email, @RequestParam String password){
		return service.login(email, password);
		
		}

	@PostMapping(value="/addCoupon")
	public void addCoupon(@RequestBody Coupon newCoupon) {
		service.addCoupon(newCoupon);
	}
	
	
	@PutMapping(value="/updateCoupon")	
	public void updateCoupon(@RequestBody Coupon updetedCoupon) {
		 service.updateCoupon(updetedCoupon);
		 
	 }

	
	@DeleteMapping(value="/deleteCoupon")	
	public void deleteCoupon(@RequestParam int couponID){
		service.deleteCoupon(couponID);
	}

	
	@GetMapping(value="/getCompanyCoupons")
	public List<Coupon> getCompanyCoupons() {
		return service.getCompanyCoupons();
	}
	
	@GetMapping(value="/getCouponsByCategory")
	public List<Coupon> getCompanyCoupons(@RequestParam Category category) {
		return service.getCompanyCoupons(category);
	}
	
	
	@GetMapping(value="/getCouponsUpToMaxPrice")
	public List<Coupon> getCompanyCoupons(@RequestParam double maxPrice) {
		return service.getCompanyCoupons(maxPrice);
	}
	
	
	@GetMapping(value="/getCompanyDetails")
	public List<Company> getCompanyDetails() {
		return service.getCompanyDetails();
	}
	
}
