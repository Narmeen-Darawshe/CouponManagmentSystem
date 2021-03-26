package com.devtech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devtech.core.Category;
import com.devtech.core.Company;
import com.devtech.core.Coupon;

@Service
public interface CompanyServices {

	public boolean login(String email, String password);
	public void addCoupon(Coupon newCoupon);
	public void updateCoupon(Coupon updetedCoupon);
	public void deleteCoupon(int couponID);
	public List<Coupon> getCompanyCoupons();
	public List<Coupon> getCompanyCoupons(Category category);
	public List<Coupon> getCompanyCoupons(double maxPrice);
	public List<Company> getCompanyDetails();
}
