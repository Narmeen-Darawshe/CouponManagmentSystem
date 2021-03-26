package com.devtech.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

import com.devtech.core.Category;
import com.devtech.core.Company;
import com.devtech.core.Coupon;
import com.devtech.repository.CompanyRepository;
import com.devtech.repository.CouponRepository;


@Service
public class CompanyServicesImpl extends ClientServices implements CompanyServices {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CouponRepository couponRepository;
	
	private int companyID;
	
	




	public CompanyServicesImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CompanyServicesImpl(CompanyRepository companyRepository, CouponRepository couponRepository, int companyID) {
		super();
		this.companyRepository = companyRepository;
		this.couponRepository = couponRepository;
		this.companyID = companyID;
	}


	@Override
	public boolean login(String email, String password){
		
		Company company  =companyRepository.findByLoginInfo(email, password);
		if (company != null) {
			//Company company = (Company)CouponList.next();
			
			this.companyID=company.getId() ;
			
			return true;
			
		}else
		return false;
		
	}
	
	
//**************************************************************************add new coupon**********************************************************************	
	public void addCoupon(Coupon newCoupon)  {
		

		
		boolean flag =false;
		
	
	
		 List<Coupon> CouponList = couponRepository.findByCompanyID(companyID);
	   
	     Date date=Date.valueOf(java.time.LocalDate.now());
	     Iterator<Coupon> itr=CouponList.iterator(); 
	     while(itr.hasNext()){  
	    	    Coupon coupon=(Coupon)itr.next();  

	    	   if(coupon.getTitle().equals(newCoupon.getTitle())) {
	    		   System.out.println("Coupon title already exists.");
	    		   flag = true; 
	    	   }  
	     }
	    	if(date.after(newCoupon.getEndDate())== true) { 
	    	 System.out.println("An expired coupon cannot be added !");
	    	 flag = true;   
	    	 
	     }
		
		if (flag ==false) { 
			flag=true;
			
			Company company=new Company(companyID);
			newCoupon.setCompany(company);
			System.out.println(newCoupon+"***********************************");
			couponRepository.save(newCoupon);
		}
		
	     }
	
		 
		 
		 
//**************************************************************************update company**********************************************************************		 
	 public void updateCoupon(Coupon updetedCoupon) {
		 	
			
			boolean flag =false;
			
			
			List<Coupon> CouponList = couponRepository.findByCompanyID(companyID);
		     
		     
		     Iterator<Coupon> itr=CouponList.iterator(); 
		     while(itr.hasNext()){  
		    	    Coupon coupon=(Coupon)itr.next();  
		    	    
		    	   if(coupon.getId() == (updetedCoupon.getId())) {
		    		  
		    		   flag=true;
	          couponRepository.updateCoupon(updetedCoupon.getCategory().ordinal(), updetedCoupon.getTitle(),updetedCoupon.getDescription(), updetedCoupon.getStartDate(), updetedCoupon.getEndDate(),  updetedCoupon.getAmount(), updetedCoupon.getPrice(), updetedCoupon.getImage(), updetedCoupon.getId());
		    		
		    	   }   
		     }
			
			if (flag ==false) {
				System.out.println("Coupon does not exists.");
			}
			
			
				
			
		 
	 }
	 
	 
	 
//**************************************************************************delete company**********************************************************************	 
	public void deleteCoupon(int couponID){
				
		boolean flag =false;
		
		
		List<Coupon> CouponList = couponRepository.findByCompanyID(companyID);
	     
	     
	     Iterator<Coupon> itr=CouponList.iterator(); 
	     while(itr.hasNext()){  
	    	    Coupon coupon=(Coupon)itr.next();  
	    	    
	    	   if(coupon.getId()==couponID) {
	    		   couponRepository.deleteCouponPurchase(couponID);
	    		   couponRepository.deleteById(couponID);

	    		  System.out.println("Coupon has been deleted");
	    		   flag=true;
	    		  
	    	   }   
	     }
		
		if (flag ==false) {
			System.out.println("Coupon does not exists.");
		
		}

	}

//**************************************************************************print company coupons**********************************************************************
	public List<Coupon> getCompanyCoupons() {
		 
		return couponRepository.findByCompanyID(companyID);
		
	 }
	
	
	
//**************************************************************************print company coupons by category**********************************************************************	
	public List<Coupon> getCompanyCoupons(Category category) {

		 
		 
		List<Coupon> CouponList = couponRepository.findByCompanyID(companyID);
		 List<Coupon> couponByCategory = new ArrayList<Coupon>();
		 
	     Iterator<Coupon> itr=CouponList.iterator(); 
	     while(itr.hasNext()){  
	    	    Coupon coupon=(Coupon)itr.next();  
	    	    
	    	   if(coupon.getCategory()==category) {
	    		   couponByCategory.add(coupon);
	    		  
	    	   }   
	     }
		 
		 return couponByCategory;
	 }


//**************************************************************************print company coupons up to max price**********************************************************************		
	public List<Coupon> getCompanyCoupons(double maxPrice) {


		 
		 return couponRepository.findcouponsUpToMaxPrice(companyID, maxPrice);
	 }
	
//**************************************************************************get company details**********************************************************************	
	public List<Company> getCompanyDetails() {
		return companyRepository.findById(companyID);
		
	 }






	 
	 
}
