package com.devtech.repository;


import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devtech.core.Coupon;
//import com.devtech.core.CustomersVsCoupons;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer>{

	

	
	@Query(value="select * from coupons c where c.company_id = ?1" , nativeQuery = true) 
    List<Coupon> findByCompanyID(int id); 
	
	@Transactional
	@Query(value="select * from customers_vs_coupons c  where c.CUSTOMER_ID = ?1" , nativeQuery = true) 
	Iterable<Entity> findPurchaseByCoustomerID(@Param("CUSTOMER_ID") int coustomerID); 
	
	@Query(value="select * from customers_vs_coupons c where c.COUPON_ID = ?1 and c.CUSTOMER_ID = ?2" , nativeQuery = true) 
	 Iterable<Entity>  findPurchaseByCouponID(int COUPON_ID, int CUSTOMER_ID); 
	
	@Query(value="select * from coupons c where c.title= ?1" , nativeQuery = true) 
    List<Coupon> findByTitle(int id); 
	
	
	@Transactional
    @Modifying
    @Query(value="update coupons c set c.CATEGORY_ID = ?1, c.TITLE = ?2, c.DESCRIPTION =?3, c.START_DATE = ?4, c.END_DATE = ?5, c.AMOUNT = ?6, c.PRICE = ?7, c.IMAGE = ?8 where c.id = ?9" , nativeQuery = true)
    void updateCoupon(int CATEGORY_ID, String TITLE, String DESCRIPTION ,Date date, Date date2, int AMOUNT, double PRICE, String IMAGE, int couponId);
	
    @Transactional
	@Modifying
	@Query(value="delete from customers_vs_coupons c  where c.COUPON_ID = :COUPON_ID" , nativeQuery = true)
    void deleteCouponPurchase(@Param("COUPON_ID") int couponId);
	
    @Transactional
	@Modifying
    @Query(value="update coupons c set c.AMOUNT = ?1 where c.id = ?2" , nativeQuery = true)
    void updateCouponAmount( int AMOUNT, int couponId);
	
	
    @Transactional
	@Modifying
	@Query(value="delete from customers_vs_coupons c  where c.CUSTOMER_ID = ?1" , nativeQuery = true)
    void deleteCouponPurchaseByCustomerID( Integer customerId);
	
	
	@Query(value="SELECT * FROM coupons  WHERE company_id = ?1 and price <= ?2", nativeQuery = true)
	List<Coupon> findcouponsUpToMaxPrice(int companyId, double price);
	
	
	//THEN true ELSE false END
	@Query(value="select count(e)>0 from customers_vs_coupons e where where e.COUPON_ID = ?1 and e.CUSTOMER_ID = ?2", nativeQuery = true)
	boolean findCouponPurchase(int couponID, int customerID);
	
	
	//@Query(value="select count(e)>0 THEN true ELSE false END from customers_vs_coupons e where where e.COUPON_ID = ?1", nativeQuery = true)
	//boolean findCouponPurchaseById(int couponID);
	
	@Transactional
	@Modifying
	@Query(value ="insert into customers_vs_coupons (CUSTOMER_ID, COUPON_ID ) values (:CUSTOMER_ID, :COUPON_ID)", nativeQuery = true)
	void addCouponPurchase(@Param("CUSTOMER_ID") int CUSTOMER_ID, @Param("COUPON_ID") int COUPON_ID);
	
	
	@Query(value ="SELECT COUNT(c) > 0 THEN true ELSE false END FROM customers_vs_coupons c WHERE c.COUPON_ID = ?1", nativeQuery = true)
	//@Query(value ="select case when count(c)> 0 then true else false end from customers_vs_coupons c where lower(c.COUPON_ID) like lower(:COUPON_ID)", nativeQuery = true)
    boolean findCouponPurchaseById(@Param("COUPON_ID") int COUPON_ID);
	
	//select case when count(c)> 0 then true else false end from Car c where lower(c.model) like lower(:model)
}
