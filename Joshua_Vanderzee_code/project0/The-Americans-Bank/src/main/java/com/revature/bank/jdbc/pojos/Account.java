package com.revature.bank.jdbc.pojos;

public class Account {
    private long AccountId;
    private String AccountType;
    private long AccountNumber;
    private long RoutingNumber;
    private double Balance;
    
    public Account() {
    	super();
    }
    
	public Account(long accountId, String accountType, long accountNumber, long routingNumber, double balance) {
		super();
		AccountId = accountId;
		AccountType = accountType;
		AccountNumber = accountNumber;
		RoutingNumber = routingNumber;
		Balance = balance;
	}
	
	public long getAccountId() {
		return AccountId;
	}
	public void setAccountId(long accountId) {
		AccountId = accountId;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}
	public long getRoutingNumber() {
		return RoutingNumber;
	}
	public void setRoutingNumber(long routingNumber) {
		RoutingNumber = routingNumber;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}

	@Override
	public String toString() {
		return "" + AccountId + " " + AccountType + " " + AccountNumber + " " + RoutingNumber + " " + Balance;
	}

}
