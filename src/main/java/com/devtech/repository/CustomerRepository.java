package com.devtech.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devtech.core.Company;
import com.devtech.core.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	 @Query(value="select * from customers c where c.email = ?1" , nativeQuery = true) 
	    List<Customer> findByEmail(String email);
	
	 
	 @Transactional
	 @Modifying
	    @Query(value="update customers c set c.FIRST_NAME = ?1, c.LAST_NAME = ?2, c.EMAIL = ?3, c.PASSWORD = ?4 where c.id = ?5" , nativeQuery = true)
	    void updateCustomer(String firstname, String lastname, String email, String password, Integer userId);
	 
	 
	 @Query(value="select * from customers c where c.email = ?1 and c.password = ?2" , nativeQuery = true) 
	    Customer findByLoginInfo(String email, String password); 
	
}
