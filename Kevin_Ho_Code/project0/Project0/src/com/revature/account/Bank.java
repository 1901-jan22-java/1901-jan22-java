package com.revature.account;

import java.util.ArrayList;

public class Bank {
	
	ArrayList<User> customers = new ArrayList<User>();
	
	public Bank()
	{
		
	}
	
	public Bank(ArrayList<User> customers)
	{
		this.customers = customers;
	}
	
	public void addCustomer(User newUser)
	{
		customers.add(newUser);
	}
	
	
}
