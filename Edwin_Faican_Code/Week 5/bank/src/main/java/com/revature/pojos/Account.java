package com.revature.pojos;

import java.math.BigDecimal;

public class Account {
	private int accountNum;
	private int userId;
	private BigDecimal balance;
	private String type;
	
	public Account() {};
	
	public Account(int userId, BigDecimal balance, String type) {
		this.userId = userId;
		this.balance = balance;
		this.type = type;
	}
	
	
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return this.accountNum + ": " + this.balance;
	}

}
