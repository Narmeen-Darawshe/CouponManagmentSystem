package com.devtech.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.devtech.services.AdminServicesImpl;
import com.devtech.services.ClientServices;

@Component
@Scope("singleton")
public class LoginManager {

	
	private AdminServicesImpl adminService;
	
	
	private ClientServices companyService;
	
	
	private ClientServices customerServices;
	 
	 private LoginManager() { }

	public ClientServices login(String email, String password, ClientType clientType){
		 
		
		    ClientServices returnedClient= null;
	  	      
	  	      
		 switch (clientType)   {
		 
	      case Administrator:
	    	  
	    	 returnedClient = adminService;
	  		
	            if(returnedClient.login(email, password)) {
	            	return returnedClient;
	            }
	            
	             break;
	             
	      case Company:
	    	  
	    	  returnedClient=companyService;
	    	  
	    	  if(returnedClient.login(email, password)) {
	            	return returnedClient;
	            }
	             break;
	             
	             
	      case Customer:
	    	  
	    	  
	    	  returnedClient=customerServices;
	    	  if(returnedClient.login(email, password)) {
	            	return returnedClient;
	            }
	             break;
	      default:
	    	  return null;


	 }
		return null; 
	 }
}
