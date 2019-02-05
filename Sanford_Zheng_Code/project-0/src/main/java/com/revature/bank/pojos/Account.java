package com.revature.bank.pojos;

public class Account {
	
	/*
	 * Instance Variables
	 */
	private Double balance;
	private String type;
	
	/*
	 * Constructors
	 */
	public Account() {
		super();
		this.balance = 0.0;
		this.type = null;
	}
	public Account(double balance) {
		this();
		this.balance = balance;
	}

	public Account(String type, double balance) {
		this();
		this.balance = balance;
		this.type = type;
	}
	/*
	 * Overrided Methods
	 */
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", type=" + type + "]";
	}
	
	/*
	 * Getters Setters
	 */
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
