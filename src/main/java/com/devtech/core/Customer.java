package com.devtech.core;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "customers") 
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	/*@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
	@JoinTable(name = "customers_vs_coupons", joinColumns = { @JoinColumn(name = "CUSTOMER_ID")},
	        inverseJoinColumns = { @JoinColumn(name = "COUPON_ID")})        
	private Set <Coupon> coupons =new HashSet<Coupon>() ;*/
	
	
	@OneToMany(mappedBy = "customer")
    private Set<CustomersVsCoupons> coupons = new HashSet<CustomersVsCoupons>();
   
	
	
	public Customer() {
		super();
		
	}
	
	

	public Customer(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



	


	public Customer(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}



	public Customer(int id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	

	/*public Set<CustomersVsCoupons> getCoupons() {
		return coupons;
	}



	public void setCoupons(Set<CustomersVsCoupons> coupons) {
		this.coupons = coupons;
	}

*/
/*
	public Set<Coupon> getCoupons() {
		return coupons;
	}



	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}
*/


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", CustomersCoupons=" + coupons + "]";
	}
	
	
	
	
}
