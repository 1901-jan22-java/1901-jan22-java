package com.jdbc.pojos;


public class UserWithdraw {
	private int accId;
	private double amount;
	
	public UserWithdraw(){}
	
	public UserWithdraw(int accId, double amount) {
		super();
		this.accId = accId;
		this.amount = amount;
	}
	
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId= accId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Withdraw [accountId=" + accId + ", amount=" + amount + "]";
	}
}