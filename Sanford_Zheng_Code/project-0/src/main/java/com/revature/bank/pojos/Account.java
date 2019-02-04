package com.revature.bank.pojos;

import java.math.BigInteger;

public class Account {
	
	/*
	 * Instance Variables
	 */
	private String username;
	private String pwd;
	private BigInteger balance;
	private AccountType type;
	
	/*
	 * Constructors
	 */
	public Account(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.balance = BigInteger.ZERO;
	}
	public Account(String username, String pwd, BigInteger balance) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.balance = balance;
	}
	
	/*
	 * Overrided Methods
	 */
	@Override
	public String toString() {
		return "Account [username=" + username + ", balance=" + balance + "]";
	}

	/*
	 * Getters and Setters
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public BigInteger getBalance() {
		return balance;
	}
	public void setBalance(BigInteger balance) {
		this.balance = balance;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	
}
