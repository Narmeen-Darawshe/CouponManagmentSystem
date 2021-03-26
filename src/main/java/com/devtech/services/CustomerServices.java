package com.devtech.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devtech.core.Category;
import com.devtech.core.Coupon;
import com.devtech.core.Customer;
import com.devtech.core.CustomersVsCoupons;

@Service
public interface CustomerServices {

	
	public boolean login( String email,  String password);
	public void purchaseCoupon(Coupon coupon) ;
	public List<Coupon> getCustomerCoupons();
	public List<Coupon> getCustomerCoupons(Category category);
	public List<Coupon> getCustomerCoupons(double maxPrice);
	public Optional<Customer> getCustomerDetails();
	
	
}
