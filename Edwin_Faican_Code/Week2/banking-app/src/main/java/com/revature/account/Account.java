package com.revature.account;

public class Account {
	private String type;
	private double balance;

	public Account() {};
	
	public Account(String type, double amount) {
		this.type = type;
		this.balance = amount;
	}
	
	public Account(String type, String amount) {
		this(type, Double.parseDouble(amount));
	}
	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public synchronized boolean withdraw(int moneyOut) {
		if(moneyOut <= balance) {
			this.balance -= moneyOut;
		} else {
			return false;
		}
		
		return true;
	}
	
	public synchronized boolean deposit(int moneyIn) {
		this.balance += moneyIn;
		return true;
	}
	
	public double viewAccount() {
		return this.balance;
	}
	
	public String toString() {
		return type + ": " + balance;
	}
}
