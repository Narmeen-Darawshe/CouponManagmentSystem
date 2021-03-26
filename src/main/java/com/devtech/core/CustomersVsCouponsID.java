package com.devtech.core;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CustomersVsCouponsID implements Serializable{

	
	
	@Column(name = "coupon_id")
	private int couponid;

	@Column(name = "customer_id")
	private int customerid;

	public CustomersVsCouponsID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomersVsCouponsID(int coupon_id, int customer_id) {
		super();
		this.couponid = coupon_id;
		this.customerid = customer_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + couponid;
		result = prime * result + customerid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomersVsCouponsID other = (CustomersVsCouponsID) obj;
		if (couponid != other.couponid)
			return false;
		if (customerid != other.customerid)
			return false;
		return true;
	}

	
	

	
	

	
	
	
}
