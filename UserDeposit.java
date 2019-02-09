package com.jdbc.pojos;

public class UserDeposit {
	private int accId;
	private double amount;
	
	public UserDeposit(){}
	
	public UserDeposit(int accId, double amount) {
		super();
		this.accId = accId;
		this.amount = amount;
	}
	
	public int getAccId() {
		return accId;
	}
	
	public void setAccId(int accId) {
		this.accId = accId;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}