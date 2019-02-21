package com.revature.pojos;

public class Accounts {
	private int id;
	private int userId;
	private double balance;
	private String type;
	public Accounts(int userId, double balance, String type) {
		super();
		this.userId = userId;
		this.balance = balance;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Accounts [id=" + id + ", userId=" + userId + ", balance=" + balance + ", type=" + type + "]";
	}
	
	
}
