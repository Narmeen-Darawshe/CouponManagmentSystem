package com.devtech.core;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.NaturalIdCache;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "coupons") 
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Coupon implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	private int company_ID;
	
	private Category category;
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private int amount;
	private double price;
	private String image;
	
	@ManyToOne
    @JoinColumn(name = "company_ID", nullable = false)
	@JsonBackReference
	private Company company;
	
	/*@ManyToMany(mappedBy="coupons")
	@JsonIgnore
     private Set<Customer> customers=new HashSet<Customer>();
*/
	 
	@OneToMany( mappedBy = "coupon",cascade = CascadeType.ALL, orphanRemoval = true )
	private Set<CustomersVsCoupons> customers = new HashSet<CustomersVsCoupons>();
	
	
	public Coupon() {
		super();
		
	}




	public Coupon(int id, int companyID, Category category, String title, String description, Date startDate,
			Date endDate, int amount, double price, String image) {
		super();
		this.id = id;
		//this.company_ID = companyID;
		this.category = category;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}




	public Coupon( Category category, String title, String description, Date startDate, Date endDate,
			int amount, double price, String image) {
		super();
	//	this.company=companyID) ;
		this.category = category;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}



	public Coupon(int id, Category category, String title, String description, Date startDate, Date endDate, int amount,
			double price, String image, Company company) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
		this.company = company;
		
	}




	public Coupon(int id) {
		super();
		this.id = id;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	//public int getCompanyID() {
		//return company_ID;
	//}




	public void setCompanyID(int companyID) {
	//	this.company_ID = companyID;
	}




	
	@Column(name = "category_ID",  nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Date getStartDate() {
		return startDate;
	}




	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}




	public Date getEndDate() {
		return endDate;
	}




	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}




	public int getAmount() {
		return amount;
	}




	public void setAmount(int amount) {
		this.amount = amount;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public Company getCompany() {
		return company;
	}




	public void setCompany(Company company) {
		this.company = company;
	}


/*
	public Set<CustomersVsCoupons> getCustomers() {
		return customers;
	}




	public void setCustomers(Set<CustomersVsCoupons> customers) {
		this.customers = customers;
	}*/




	@Override
	public String toString() {
		return "Coupon [id=" + id + ", category=" + category + ", title=" + title + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", amount=" + amount + ", price=" + price
				+ ", image=" + image + ", company=" + company.getId() + "]";
	}





	
	
	
	

	

}
