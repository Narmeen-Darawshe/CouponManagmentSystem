package com.devtech.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devtech.core.CustomersVsCoupons;
import com.devtech.core.CustomersVsCouponsID;

@Repository
public interface Customers_vs_CouponsRepository extends JpaRepository<CustomersVsCoupons, CustomersVsCouponsID> {

	
	
	@Query(value="select * from customers_vs_coupons c where c.COUPON_ID = ?1" , nativeQuery = true) 
	 Set<CustomersVsCoupons>  findPurchaseByCouponID(int COUPON_ID); 
	
	@Query(value="select * from customers_vs_coupons c  where c.CUSTOMER_ID = ?1" , nativeQuery = true) 
	Set<CustomersVsCoupons> findPurchaseByCoustomerID(int CUSTOMER_ID); 

}
