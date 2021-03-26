package com.devtech.controller;

public abstract class ClientController {
	protected AdminController adminController;
	protected ClientController clientController;
	
	protected  CompanyController companyController;
	
	public abstract boolean login(String email, String password) ; 
}
