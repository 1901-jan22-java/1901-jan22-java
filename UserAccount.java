package com.jdbc.pojos;

public class UserAccount {
	private int accId;
	private int userId;
	private String accType;
	private Double balance;
	
	public UserAccount() {}
	
	public UserAccount(int accId, int userId, String accType, double balance) {
		super();
		this.accId = accId;
		this.userId = userId;
		this.accType = accType;
		this.balance = balance;
	}
	
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accId + ", userId=" + userId + ", "
				+ "accountType=" + accType + ", amount=" + balance + "]";
	}
}