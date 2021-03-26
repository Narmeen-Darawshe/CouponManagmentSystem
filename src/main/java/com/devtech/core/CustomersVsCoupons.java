package com.devtech.core;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "customers_vs_coupons")
public class CustomersVsCoupons {
	
	  @EmbeddedId
	  CustomersVsCouponsID id ;

		
	@ManyToOne
	@MapsId( "customerid")
	//@JoinColumn(name = "customer_id")
	//@JsonBackReference
	 Customer customer;

	
	@ManyToOne
	@MapsId( "couponid")
	//@JoinColumn(name = "coupon_id")
	//@JsonBackReference
	 Coupon coupon;
    
	

	
	public CustomersVsCoupons() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomersVsCoupons( Coupon coupon, Customer customer) {
		super();
		this.id = new CustomersVsCouponsID(coupon.getId(), customer.getId());
		this.coupon = coupon;
		this.customer = customer;
		 // this.id = new CustomersVsCouponsID(coupon.getId(), customer.getId());
	}


	public CustomersVsCouponsID getId() {
		return id;
	}


	public void setId(CustomersVsCouponsID id) {
		this.id = id;
	}


	public Coupon getCoupon() {
		return coupon;
	}


	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "CustomersVsCoupons [customer=" + customer + ", coupon=" + coupon + "]";
	}
	

	

	
	
	
}
