package com.revature.account;

import java.util.ArrayList;

public class User{

	private String username;
	private String password;
	private ArrayList<Account> accounts;
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public boolean setUsername(String username) {
		if(username.equals(""))
			return false;
		
		this.username = username;
		return true;
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String password) {
		if(password.equals(""))
			return false;
		
		this.password = password;
		return true;
	}

	public ArrayList<Account> getAccountList() {
		return accounts;
	}
	
	public boolean addAccount(String name, double money)
	{
		if(name.equals(""))
			return false;
		
		Account newAccount = new Account(money, name);
		accounts.add(newAccount);
		return true;
	}

	public boolean removeAccount(String name)
	{
		for (Account check : accounts)
		{
			if(check.getName().equals(name))
			{
				if(check.getMoney() == 0)
				{
					accounts.remove(check);
					return true;
				}
			}
		}
		
		return false;
	}
}
