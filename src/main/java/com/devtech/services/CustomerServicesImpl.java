package com.devtech.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtech.core.Category;
import com.devtech.core.Company;
import com.devtech.core.Coupon;
import com.devtech.core.Customer;
import com.devtech.core.CustomersVsCoupons;
import com.devtech.repository.CouponRepository;
import com.devtech.repository.CustomerRepository;
import com.devtech.repository.Customers_vs_CouponsRepository;


@Service
public class CustomerServicesImpl extends ClientServices implements CustomerServices{
	
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private Customers_vs_CouponsRepository customers_vs_CouponsRepository;
	
	private int customerID;
	
	
	
	public CustomerServicesImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerServicesImpl(CouponRepository couponRepository, CustomerRepository customerRepository,
			int customerID) {
		super();
		this.couponRepository = couponRepository;
		this.customerRepository = customerRepository;
		this.customerID = customerID;
	}


	@Override
	public boolean login(String email, String password) {


		Customer customer  =customerRepository.findByLoginInfo(email, password);
		if (customer != null) {
			
			
			this.customerID=customer.getId() ;
			
			return true;
			
		}else
		return false;
	}

	
//**************************************************************************purchase a Coupon**********************************************************************		
	public void purchaseCoupon(Coupon coupon) {
		
	
		List<Entity> array  = (List<Entity>) couponRepository.findPurchaseByCouponID(coupon.getId(),customerID);
		
		
		if(array.isEmpty()) {		    	      
	     
		 coupon=couponRepository.getOne(coupon.getId());
		
			if(coupon.getAmount()>0) {
				
				Date date=Date.valueOf(java.time.LocalDate.now());
				
				
				if(date.after(coupon.getEndDate())== false) {
					
					
					couponRepository.addCouponPurchase(customerID, coupon.getId());
					int amount =coupon.getAmount()-1;
					coupon.setAmount(amount);
					couponRepository.updateCouponAmount(amount,coupon.getId());
					
					
				}else System.out.println("Coupon has expired!");
				
			}else  System.out.println("Coupon does not exists.");
			
		} else System.out.println("Coupon has already been purchased");
		
	}	


	
//**************************************************************************get customer coupons**********************************************************************
	public List<Coupon> getCustomerCoupons() {
		
		
		
		Set<CustomersVsCoupons> purchaseList  =  customers_vs_CouponsRepository.findPurchaseByCoustomerID(customerID);
		List<Coupon> couponBycustomerID = new ArrayList<Coupon>();
		
		   
		     
	     Iterator<CustomersVsCoupons> itr=purchaseList.iterator(); 
	     while(itr.hasNext()){  
	    	 Coupon coupon=itr.next().getCoupon();  
	    	 
	    	    couponBycustomerID.add(couponRepository.getOne(coupon.getId())) ;
	     }
			return couponBycustomerID;
	}
	
	
	
//**************************************************************************get customer coupons by category**********************************************************************	
	public List<Coupon> getCustomerCoupons(Category category) {
		

		
        Set<CustomersVsCoupons> purchaseList  =  customers_vs_CouponsRepository.findPurchaseByCoustomerID(customerID);
        List<Coupon> couponByCategory = new ArrayList<Coupon>();
		
	     Iterator<CustomersVsCoupons> itr=purchaseList.iterator(); 
	     while(itr.hasNext()){  
	    	    Coupon coupon=itr.next().getCoupon();  
	    	    coupon=couponRepository.getOne(coupon.getId());
	    	    if(coupon.getCategory()==category) {
	    	    couponByCategory.add(coupon) ;
	    	    
	    	    }
	     }
	     
	     
			return couponByCategory;
	}

	
//**************************************************************************get customer coupons up to max price**********************************************************************
	public List<Coupon> getCustomerCoupons(double maxPrice){
		

			
        Set<CustomersVsCoupons> purchaseList  =  customers_vs_CouponsRepository.findPurchaseByCoustomerID(customerID);
        List<Coupon> couponByPrice = new ArrayList<Coupon>();
		     
		     Iterator<CustomersVsCoupons> itr=purchaseList.iterator(); 
		     while(itr.hasNext()){  
		    	    Coupon coupon=itr.next().getCoupon();  
		    	    coupon=couponRepository.getOne(coupon.getId());
		    	   
		    	    if(coupon.getPrice() <= maxPrice) {
		    	    couponByPrice.add(coupon) ;
		    	    
		    	    }
		     }
		     
		     
				return couponByPrice;
		}
	
	

//**************************************************************************get customer details**********************************************************************
	public Optional<Customer> getCustomerDetails() {
		return customerRepository.findById(customerID);
	 }

	
	
	

}
