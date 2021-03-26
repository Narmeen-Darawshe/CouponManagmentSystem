package com.devtech.services;

public abstract class ClientServices {

	protected AdminServicesImpl addminService;
	protected CompanyServices companyServices;
	protected ClientServices clientServices;
	
	
	public abstract boolean login(String email, String password);
	
}
