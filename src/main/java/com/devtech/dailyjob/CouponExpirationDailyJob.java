package com.devtech.dailyjob;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.devtech.core.Coupon;
import com.devtech.core.Customer;
import com.devtech.core.CustomersVsCoupons;
import com.devtech.core.CustomersVsCouponsID;
import com.devtech.repository.CouponRepository;
import com.devtech.repository.Customers_vs_CouponsRepository;



@Configuration
@EnableScheduling
@EnableAsync
@Component
@Scope("singleton")
public class CouponExpirationDailyJob implements Runnable{
	
	
	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private Customers_vs_CouponsRepository customers_vs_CouponsRepository; 

	
	@Async
	@Scheduled(fixedDelay = 1000000)
	public void run()  {
		long threadId = Thread.currentThread().getId();
		delete();
		
	    System.out.println(
	      "Fixed delay task - " + System.currentTimeMillis() / 1000+ "          *****"+threadId);
	   
	}
	

public void delete() {
		
	
	
	
	List<Coupon> couponList = couponRepository.findAll();

	     
	     Iterator<Coupon> itr=couponList.iterator(); 
	     while(itr.hasNext()){  
	    	    Coupon coupon=(Coupon)itr.next();  

	   	     
             Date date=Date.valueOf(java.time.LocalDate.now());
				
				//check if Coupon date has expired! 
				if(date.after(coupon.getEndDate())== true) { 
					 
					//check if coupon exists in purchase table and delete it
					if(customers_vs_CouponsRepository.findPurchaseByCouponID(coupon.getId())!=null ){
						
	    		         couponRepository.deleteCouponPurchase(coupon.getId());
	    		  
					}
	    		  couponRepository.deleteById(coupon.getId());
	    		  System.out.println("Coupon has been deleted");
	    		  
	    		  
	    	   }   
	     }
		
	
 
  	
	    
	
}


}
