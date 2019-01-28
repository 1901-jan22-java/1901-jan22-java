package com.revature.account;

public class Account {
	private String userName;
	private String password; 
	private int amount;
	
	public Account(String userName, String password, int amount) {
		this.userName = userName;
		this.password = password;
		this.amount = amount;
	}
	
	public synchronized boolean withdraw(int moneyOut) {
		if(moneyOut <= amount) {
			this.amount -= moneyOut;
		} else {
			return false;
		}
		
		return true;
	}
	
	public synchronized boolean deposit(int moneyIn) {
		this.amount += moneyIn;
		return true;
	}
	
	public int viewAccount() {
		return this.amount;
	}
}
