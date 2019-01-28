package com.revature.account;

import java.util.ArrayList;

public class Users implements Account{

	private String username;
	private String password;
	private ArrayList<Account> accounts;
	
	public Users(String username, String password, ArrayList<Account> accounts)
	{
		this.username = username;
		this.password = password;
		this.setAccounts(accounts);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public boolean withdraw() {
		
		return false;
	}

	@Override
	public boolean deposit() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
