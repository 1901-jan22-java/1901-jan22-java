package com.revature.account;

import java.util.ArrayList;

public class Bank {
	
	ArrayList<Users> customers = new ArrayList<Users>();
	
	public Bank()
	{
		
	}
	
	public Bank(ArrayList<Users> customers)
	{
		this.customers = customers;
	}
	
	public void addCustomer(Users newUser)
	{
		customers.add(newUser);
	}
	
	
}
