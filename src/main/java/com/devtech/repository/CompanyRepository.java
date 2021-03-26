package com.devtech.repository;


import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devtech.core.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	


    @Query(value="select * from companies c where c.email = ?1" , nativeQuery = true) 
    List<Company> findByEmail(String email); 
    
    @Query(value="select * from companies c where c.email = ?1 and c.password = ?2" , nativeQuery = true) 
    Company findByLoginInfo(String email, String password); 
    
    
    @Query(value="select * from companies c where c.id = ?1" , nativeQuery = true) 
    List<Company> findById(int id);  
    
    @Query(value="select * from companies c where c.name = ?1" , nativeQuery = true) 
    List<Company> findByName( String name);
    
    @Transactional
    @Modifying
    @Query(value="update companies c set c.email = ?1, c.password = ?2 where c.id = ?3" , nativeQuery = true)
    void updateCompany(String email, String password, int userId);



	
	
	 
	
}
