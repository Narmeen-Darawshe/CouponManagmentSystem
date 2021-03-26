package com.devtech.core;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "companies") 
public class Company {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String name;
   private String email;
   private String password;
   
   @OneToMany(mappedBy = "company")
   @JsonManagedReference
   private Set<Coupon> coupons;
   

 
public Company() {
	super();
	
}



public Company(int id) {
	super();
	this.id = id;
}



public Company(int id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
}





public Company(int id, String name, String email, String password) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
}


public Company(String name, String email, String password) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
}


public Company(int id, String name, String email, String password, Set<Coupon> coupons) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.coupons = coupons;
}




public int getId() {
	return id;
}




public void setId(int id) {
	this.id = id;
}




public String getName() {
	return name;
}




public void setName(String name) {
	this.name = name;
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




public Set<Coupon> getCoupons() {
	return coupons;
}




public void setCoupons(Set<Coupon> coupons) {
	this.coupons = coupons;
}




@Override
public String toString() {
	return "Company [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", coupons=" + coupons + "]";
}
   
   
   
	
}
