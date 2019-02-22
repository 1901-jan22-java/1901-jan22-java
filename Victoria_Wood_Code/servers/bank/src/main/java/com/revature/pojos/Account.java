package com.revature.pojos;

public class Account {
	
	private int id;
	private double balance;
	private int userId;
	private String type;
	
	
	public Account() {}
	
	public Account(double balance, int userId, String type) {
		super();
		this.balance = balance;
		this.userId = userId;
		this.type = type;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", userId=" + userId + ", type=" + type + "]";
	}
	
	
	

}
