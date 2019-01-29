package com.revature.account;

public class Account 
{
	private double money;
	private String name;
	
	public Account(double money, String name)
	{
		this.money = money;
		this.name = name;
	}
	
	public Account(String name)
	{
		this.name = name;
		this.money = 0;
	}
	
	public boolean withdraw(double money)
	{
		if(this.money - money > 0)
			return false;
		else
		{
			this.money -= money;
			return true;
		}
	}
	
	public boolean deposit(double money) 
	{
		this.money += money;
		
		return true;
	}

	public double getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
